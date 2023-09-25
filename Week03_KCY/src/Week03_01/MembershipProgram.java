package Week03_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MembershipProgram {
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField phoneField;

    public MembershipProgram() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        JLabel label = new JLabel("회원 등록하기");
        label.setLocation(150,0);
        label.setSize(100, 20);
        frame.getContentPane().add(label);
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("이름:");
        lblName.setBounds(50, 50, 80, 25);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 150, 25);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);

        JLabel lblPassword = new JLabel("비밀번호:");
        lblPassword.setBounds(50, 100, 80, 25);
        frame.getContentPane().add(lblPassword);

        passwordField = new JTextField();
        passwordField.setBounds(150, 100, 150, 25);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        JLabel lblEmail = new JLabel("이메일:");
        lblEmail.setBounds(50, 150, 80, 25);
        frame.getContentPane().add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(150, 150, 150, 25);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);

        JLabel lblPhone = new JLabel("전화번호:");
        lblPhone.setBounds(50, 200, 80, 25);
        frame.getContentPane().add(lblPhone);

        phoneField = new JTextField();
        phoneField.setBounds(150, 200, 150, 25);
        frame.getContentPane().add(phoneField);
        phoneField.setColumns(10);

        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                String phone = phoneField.getText();

                JOptionPane.showMessageDialog(frame, "회원 정보가 저장되었습니다.");
            }
        });
        btnSave.setBounds(50, 250, 100, 30);
        frame.getContentPane().add(btnSave);

        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                phoneField.setText("");
            }
        });
        btnCancel.setBounds(200, 250, 100, 30);
        frame.getContentPane().add(btnCancel);

        // 프레임을 보이게 하는 코드는 initialize 메서드 안에 위치해야 합니다.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MembershipProgram window = new MembershipProgram();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
