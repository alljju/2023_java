package Week03_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MileToKilometerConverter {
    private JFrame frame;
    private JTextField mileField;
    private JLabel resultLabel;

    public MileToKilometerConverter() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMile = new JLabel("마일:");
        lblMile.setBounds(50, 50, 80, 25);
        frame.getContentPane().add(lblMile);

        mileField = new JTextField();
        mileField.setBounds(150, 50, 150, 25);
        frame.getContentPane().add(mileField);
        mileField.setColumns(10);

        JButton btnConvert = new JButton("변환");
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double miles = Double.parseDouble(mileField.getText());
                    double kilometers = miles * 1.60934; // 1 마일 = 1.60934 킬로미터
                    resultLabel.setText("결과: " + kilometers + " 킬로미터");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("올바른 숫자를 입력하세요.");
                }
            }
        });
        btnConvert.setBounds(150, 100, 100, 30);
        frame.getContentPane().add(btnConvert);

        resultLabel = new JLabel("결과:");
        resultLabel.setBounds(50, 150, 250, 25);
        frame.getContentPane().add(resultLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MileToKilometerConverter window = new MileToKilometerConverter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

