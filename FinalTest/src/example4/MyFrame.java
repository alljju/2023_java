package example4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField id, title, publisher, content, search;
    JButton previousButton, nextButton, insertButton, searchButton, clearButton, deleteButton;
    ResultSet rs;
    Statement stmt;
    Connection con;

    public MyFrame() throws SQLException {
        super("Database Viewer");
        con = makeConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * FROM Student");
        
        setLayout(new GridLayout(0, 2));
        
        add(new JLabel("stuId", JLabel.CENTER));
        id = new JTextField();
        add(id);
        
        add(new JLabel("name", JLabel.CENTER));
        title = new JTextField();
        add(title);
        
        add(new JLabel("tel", JLabel.CENTER));
        publisher = new JTextField();
        add(publisher);
        
        add(new JLabel("dept", JLabel.CENTER));
        content = new JTextField();
        add(content);
        

        
        add(new JLabel("검색 결과", JLabel.CENTER));
        search = new JTextField();
        add(search);
        

        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {    
                    int currentId = Integer.parseInt(id.getText());
                    String query = "SELECT * FROM Student WHERE stuId < ? ORDER BY stuId DESC LIMIT 1";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, currentId);
                    ResultSet result = pstmt.executeQuery();
                    
                    if (result.next()) {
                        id.setText("" + result.getInt("stuId"));
                        title.setText(result.getString("name"));
                        publisher.setText(result.getString("tel"));
                        content.setText(result.getString("tel"));
                    } else {
                        JOptionPane.showMessageDialog(null, "No previous record");
                    }
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error navigating records");
                }
            }
        });
        add(previousButton);

        
        nextButton = new JButton("Next");
        add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    int currentId = Integer.parseInt(id.getText());
                    String query = "SELECT * FROM Student WHERE stuId > ? ORDER BY stuId ASC LIMIT 1";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, currentId);
                    ResultSet result = pstmt.executeQuery();
                    
                    if (result.next()) {
                        id.setText("" + result.getInt("stuId"));
                        title.setText(result.getString("name"));
                        publisher.setText(result.getString("tel"));
                        content.setText(result.getString("tel"));
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No next record");
                    }
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error navigating records");
                }
            }
        });
        
        insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String insertQuery = "INSERT INTO Student (stuId, name, tel, dept) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(insertQuery);
                    pstmt.setInt(1, Integer.parseInt(id.getText()));
                    pstmt.setString(2, title.getText());
                    pstmt.setString(3, publisher.getText());
                    pstmt.setString(4, content.getText());
                   
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student Inserted Successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error Inserting Student");
                }
            }
        });
        add(insertButton);
        
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Clearing all the text fields
                id.setText("");
                title.setText("");
                publisher.setText("");
                content.setText("");
                search.setText("");
            }
        });
        add(clearButton);
        
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String deleteQuery = "DELETE FROM Student WHERE stuId = ?";
                    PreparedStatement pstmt = con.prepareStatement(deleteQuery);
                    pstmt.setInt(1, Integer.parseInt(id.getText()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error Deleting Student");
                }
            }
        });
        add(deleteButton);
        
        searchButton = new JButton("Search");
        add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String searchKeyword = search.getText();
                try {
                	String query = "SELECT * FROM Student WHERE stuId Like '%"+searchKeyword+"%'";
                    ResultSet searchResult = stmt.executeQuery(query);
                    
                    if (searchResult.next()) {
                        id.setText("" + searchResult.getInt("stuId"));
                        title.setText(searchResult.getString("name"));
                        publisher.setText(searchResult.getString("tel"));
                        content.setText(searchResult.getString("dept"));
                        
                    } else {
                        System.out.println("검색 결과가 없습니다");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

	private Connection makeConnection() {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/Duksung";

		String user = "root";//자신의 workbench 아이디

		String pass = "1340";//자신의 workbench 비번

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("드라이버 적재 성공");

			con = DriverManager.getConnection(url, user, pass);

			System.out.println("데이터베이스 연결 성공");

		} catch (ClassNotFoundException e) {

			System.out.println("드라이버를 찾을 수 없습니다.");

		} catch (SQLException e) {

			System.out.println("연결을 실패하였습니다.");

		}

		return con;
	}
}
