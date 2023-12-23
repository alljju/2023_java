package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GalagaGame extends JFrame {
    private GamePanel gamePanel;
    private JButton startButton;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private Timer gameTimer;
    private long elapsedTime;

    public GalagaGame() {
        setTitle("Galaga Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gamePanel = new GamePanel(this); // Pass the GalagaGame instance to the GamePanel
        add(gamePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        scoreLabel = new JLabel("Score: 0");
        timeLabel = new JLabel("Time: 0s");
        startButton = new JButton("Start Game");
        startButton.addActionListener(e -> startGame());

        bottomPanel.add(scoreLabel);
        bottomPanel.add(timeLabel);
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startGame() {
        gamePanel.startGame();
        startButton.setEnabled(false);

        // 추가: 경과 시간 초기화
        elapsedTime = 0;

        // 수정: Timer의 ActionListener에 경과 시간 측정 로직 추가
        gameTimer = new Timer(100, e -> {
            elapsedTime += 100; // 100밀리초마다 증가 (1초당 10 증가)
            updateTimerLabel();
        });
        gameTimer.start();
    }

    private void updateTimerLabel() {
        int seconds = (int) (elapsedTime / 1000);
        timeLabel.setText("Time: " + seconds + "s");
    }

    public void setScoreLabel(String text) {
        scoreLabel.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GalagaGame::new);
    }

    // 추가: gameTimer 반환하는 메서드
    public Timer getGameTimer() {
        return gameTimer;
    }
}
