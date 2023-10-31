package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HouseDrawingApp extends JPanel {
    public HouseDrawingApp() {
        setPreferredSize(new Dimension(400, 400));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 집 그리기
        g.setColor(Color.BLUE);
        g.fillRect(100, 200, 200, 200);

        // 지붕 그리기
        int[] xPoints = {100, 300, 200};
        int[] yPoints = {200, 200, 100};
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);

        // 문 그리기
        g.setColor(Color.ORANGE);
        g.fillRect(170, 300, 60, 100);

        // 창문 그리기
        g.setColor(Color.YELLOW);
        g.fillRect(130, 230, 40, 40);

        // 굴뚝 그리기
        g.setColor(Color.GRAY);
        g.fillRect(220, 110, 20, 60);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("집 그리기 애플리케이션");
        HouseDrawingApp housePanel = new HouseDrawingApp();
        frame.add(housePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

