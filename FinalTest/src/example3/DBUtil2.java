package example3;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBUtil2 {

	public static Connection makeConnection() {

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

	

	

	public static void main(String arg[]) throws SQLException{

			Connection con = makeConnection();
			try {
				String sql = ""+ "INSERT INTO Student (stuId, name, tel, dept) + VALUES (?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "2022001");
                pstmt.setString(2, "Minji lee");
                pstmt.setString(3, "000-0000-0001");
                pstmt.setString(4, "Cyber Security");
			pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con != null) {
					try {
						con.close();
					}catch(SQLException e) {}
				}
			}

			}	

}
