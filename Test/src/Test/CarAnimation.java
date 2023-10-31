package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Car extends JPanel {
    private Color color;
    private int width;
    private int height;
    private int x;
    private int y;
    private int speed;

    public Car(Color color, int width, int height, int x, int y, int speed) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        setPreferredSize(new Dimension(800, 400));
    }

    public void move() {
        x += speed;
        if (x > getWidth()) {
            x = -width;
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);

        // 몸통 그리기
        g.fillRect(x, y, width, height);

        // 바퀴 그리기
        int wheelDiameter = 20;
        g.setColor(Color.BLACK);
        g.fillOval(x, y + height - wheelDiameter, wheelDiameter, wheelDiameter);
        g.fillOval(x + width - wheelDiameter, y + height - wheelDiameter, wheelDiameter, wheelDiameter);
    }
}

public class CarAnimation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Animation");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Car car1 = new Car(Color.RED, 80, 40, 100, 100, 2);
        Car car2 = new Car(Color.BLUE, 80, 40, 0, 200, 3);

        frame.add(car1);
        frame.add(car2);

        frame.setVisible(true);

        Timer timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                car1.move();
                car2.move();
            }
        });
        timer.start();
    }
}




