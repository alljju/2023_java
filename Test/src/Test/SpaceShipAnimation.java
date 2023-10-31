package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceShipAnimation extends JPanel implements ActionListener {
    private Image spaceship;
    private int x, y;
    private Timer timer;

    public SpaceShipAnimation() {
        // 우주선 이미지 로드 및 크기 조정
        ImageIcon ii = new ImageIcon("spaceship.png");
        Image originalImage = ii.getImage();
        spaceship = originalImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        x = getWidth() - spaceship.getWidth(this);
        y = 600;


        // 타이머 설정 (매 10ms마다 actionPerformed 호출)
        timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 우주선 그리기
        g.drawImage(spaceship, x, y, this);
    }

    public void actionPerformed(ActionEvent e) {
        x += 1;
        y -= 1;

        if (x > getWidth()) {
            x = 0;
            y = getHeight() - spaceship.getHeight(this);
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SpaceShip Animation");
        SpaceShipAnimation spaceShipAnimation = new SpaceShipAnimation();
        frame.add(spaceShipAnimation);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

