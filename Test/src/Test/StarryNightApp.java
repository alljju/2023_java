package Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class Star extends JPanel {
    private int x;
    private int y;

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 2, 2); // 간단하게 2x2 크기의 사각형으로 별을 나타냅니다.
    }
}

public class StarryNightApp extends JFrame {
    private ArrayList<Star> stars;

    public StarryNightApp() {
        stars = new ArrayList<>();
        generateRandomStars();

        setTitle("밤하늘 별빛");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawStars(g);
            }
        });
        setVisible(true);
    }

    private void generateRandomStars() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            stars.add(new Star(x, y));
        }
    }

    private void drawStars(Graphics g) {
        for (Star star : stars) {
            star.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        new StarryNightApp();
    }
}
