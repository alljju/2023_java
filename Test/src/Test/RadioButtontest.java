package Test;
//라디오버튼 사진띄우기
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtontest {
    private JFrame frame;
    private JRadioButton birdRadio, catRadio, dogRadio, rabbitRadio, pigRadio;
    private JLabel label;

    public RadioButtontest() {
        frame = new JFrame("라디오버튼 예제");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        birdRadio = new JRadioButton("Bird");
        catRadio = new JRadioButton("Cat");
        dogRadio = new JRadioButton("Dog");
        rabbitRadio = new JRadioButton("Rabbit");
        pigRadio = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdRadio);
        group.add(catRadio);
        group.add(dogRadio);
        group.add(rabbitRadio);
        group.add(pigRadio);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));
        leftPanel.add(birdRadio);
        leftPanel.add(catRadio);
        leftPanel.add(dogRadio);
        leftPanel.add(rabbitRadio);
        leftPanel.add(pigRadio);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);

        birdRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("Monster.png");
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
        });

        catRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("yang.jpg");
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
        });

        dogRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("dog.jpeg");
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
        });

        rabbitRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("rabbit.jpg");
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
        });

        pigRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("pig.png");
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImg));
            }
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(label, BorderLayout.CENTER);

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RadioButtontest();
    }
}

