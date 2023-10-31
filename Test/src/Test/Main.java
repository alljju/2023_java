package Test;
//2차함수가 화면에 그려지는 프로그램
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {
    private JButton drawButton;
    private JTextField aField, bField, cField;
    private int a, b, c;

    public Main() {
        drawButton = new JButton("그리기");
        drawButton.addActionListener(this);

        aField = new JTextField(5);
        bField = new JTextField(5);
        cField = new JTextField(5);

        add(new JLabel("a:"));
        add(aField);
        add(new JLabel("b:"));
        add(bField);
        add(new JLabel("c:"));
        add(cField);
        add(drawButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (a != 0) {
            drawGraph(g);
        }
    }

    private void drawGraph(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.BLACK);

        // x축 그리기
        g.drawLine(50, height / 2, width - 50, height / 2);

        // y축 그리기
        g.drawLine(width / 2, 50, width / 2, height - 50);

        // 함수 그래프 그리기
        g.setColor(Color.RED);
        for (int x = -width / 2; x < width / 2; x++) {
            int y = a * x * x + b * x + c;
            g.fillRect(x + width / 2, height / 2 - y, 1, 1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            a = Integer.parseInt(aField.getText());
            b = Integer.parseInt(bField.getText());
            c = Integer.parseInt(cField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "유효한 숫자를 입력하세요.");
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2차 함수 그래프");
        Main mainPanel = new Main();
        frame.add(mainPanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
