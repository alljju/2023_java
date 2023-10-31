package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessNumberGame {
    private JFrame frame;
    private JTextField inputField;
    private JButton guessButton;
    private JLabel hintLabel;

    private int secretNumber;

    public GuessNumberGame() {
        frame = new JFrame("숫자 추측 게임");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1부터 100까지의 랜덤 숫자 생성
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;

        inputField = new JTextField(10);
        guessButton = new JButton("추측");
        hintLabel = new JLabel();

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(inputField.getText());
                    if (userGuess == secretNumber) {
                        hintLabel.setText("정답입니다!");
                        inputField.setBackground(Color.WHITE);
                    } else if (userGuess < secretNumber) {
                        hintLabel.setText("더 높은 숫자입니다.");
                        inputField.setBackground(Color.RED);
                    } else {
                        hintLabel.setText("더 낮은 숫자입니다.");
                        inputField.setBackground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    hintLabel.setText("올바른 숫자를 입력하세요.");
                    inputField.setBackground(Color.RED);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("숫자 입력: "));
        panel.add(inputField);
        panel.add(guessButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(hintLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuessNumberGame();
    }
}

