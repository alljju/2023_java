package Test;
//신호등 프로그램
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightProgram extends JPanel implements ActionListener {
    int light_number = 0;

    public TrafficLightProgram() {
        setLayout(new BorderLayout());
        JButton b = new JButton("신호변경");
        b.addActionListener(this);
        add(b, BorderLayout.SOUTH);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = 50;
        int x = (getWidth() - diameter) / 2;
        int y = 30;

        g.setColor(Color.BLACK);
        g.fillRect(x, y, diameter, diameter * 3);

        if (light_number == 0) {
            g.setColor(Color.RED);
            g.fillOval(x, y, diameter, diameter);
        } else if (light_number == 1) {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y + diameter, diameter, diameter);
        } else if (light_number == 2) {
            g.setColor(Color.GREEN);
            g.fillOval(x, y + diameter * 2, diameter, diameter);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (++light_number >= 3)
            light_number = 0;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light");
        TrafficLightProgram trafficLight = new TrafficLightProgram();
        frame.add(trafficLight);
        frame.setSize(150, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


