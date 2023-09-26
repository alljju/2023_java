package Week04_03;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card extends JFrame {
    private BufferedImage image;

    public Card() {
        try {
            // 이미지 파일 로드 (파일 경로를 적절히 수정하세요)
            image = ImageIO.read(new File("yang.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("나의 명함");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 텍스트 그리기
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("이름: 홍길동", 50, 50);
        g.drawString("직책: 개발자", 50, 80);
        g.drawString("이메일: hong@example.com", 50, 110);
        g.drawString("전화번호: 123-456-7890", 50, 140);

        // 이미지 그리기
        if (image != null) {
            g.drawImage(image, 250, 20, 100, 100, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Card());
    }
}

