package Test;

//주사위 던지는 게임
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Dice extends JPanel {
    private int x, y, currentValue;
    private Color color;

    public Dice(int x, int y, Color color, int currentValue) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.currentValue = currentValue;
        setPreferredSize(new Dimension(100, 100));
    }

    public void rollDice() {
        Random rand = new Random();
        currentValue = rand.nextInt(6) + 1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, 80, 80);
        g.setColor(Color.BLACK);

        switch (currentValue) {
            case 1:
                drawOne(g);
                break;
            case 2:
                drawTwo(g);
                break;
            case 3:
                drawThree(g);
                break;
            case 4:
                drawFour(g);
                break;
            case 5:
                drawFive(g);
                break;
            case 6:
                drawSix(g);
                break;
        }
    }

    private void drawOne(Graphics g) {
        g.fillOval(x + 30, y + 30, 20, 20);
    }

    private void drawTwo(Graphics g) {
        g.fillOval(x + 10, y + 10, 20, 20);
        g.fillOval(x + 50, y + 50, 20, 20);
    }

    private void drawThree(Graphics g) {
        drawOne(g);
        drawTwo(g);
    }

    private void drawFour(Graphics g) {
        drawTwo(g);
        g.fillOval(x + 10, y + 50, 20, 20);
        g.fillOval(x + 50, y + 10, 20, 20);
    }

    private void drawFive(Graphics g) {
        drawFour(g);
        drawOne(g);
    }

    private void drawSix(Graphics g) {
        drawFour(g);
        g.fillOval(x + 10, y + 30, 20, 20);
        g.fillOval(x + 50, y + 30, 20, 20);
    }
}

public class DiceGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dice Roll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(1, 2)); // 1행 2열의 GridLayout 설정
        Dice dice1 = new Dice(100, 30, Color.RED, 1);
        Dice dice2 = new Dice(160, 30, Color.BLUE, 1);

        panel.add(dice1);
        panel.add(dice2);

        frame.add(panel); // 패널을 프레임에 추가

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dice1.rollDice();
                    dice2.rollDice();
                }
            }
        });

        frame.setFocusable(true);
        frame.setVisible(true);
    }
}



