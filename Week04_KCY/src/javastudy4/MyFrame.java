package javastudy4;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 154);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("성적"); // 수정: 변수명 변경 (1b1NewLabel -> lblNewLabel)
        lblNewLabel.setBounds(61, 13, 57, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(170, 10, 97, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("입력");
        btnNewButton.addActionListener(e -> {
            list.add(Integer.parseInt(textField.getText()));
        });
        btnNewButton.setBounds(61, 38, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("평균계산"); // 수정: Jbutton -> JButton
        btnNewButton_1.setBounds(170, 38, 97, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("모든 학생의 평균"); // 수정: 변수명 변경 (1b1NewLabel_1 -> lblNewLabel_1)
        lblNewLabel_1.setBounds(31, 80, 122, 15);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(170, 77, 97, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        btnNewButton_1.addActionListener(e -> {
            int sum = 0;
            for (int s : list) { // 수정: List -> list
                sum += s;
            }
            
            textField_1.setText("" + (sum / list.size()));
        });
    }
}
