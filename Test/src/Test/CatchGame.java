package Test;
//몬스터가 랜덤으로 생성되면 잡기 게임
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Monster {
    int x, y, hp;
    Image img;

    Monster(int x, int y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        ImageIcon icon = new ImageIcon("monster.png");
        img = icon.getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, 50, 50, null);
    }
}

public class CatchGame extends JPanel implements MouseListener {
    private ArrayList<Monster> monsters;

    public CatchGame() {
        monsters = new ArrayList<>();
        addMouseListener(this);
        spawnMonsters(); // 랜덤 몬스터 생성 함수 호출
    }

    // 랜덤으로 몬스터 생성
    private void spawnMonsters() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // 10마리 생성 (원하는 개수로 변경 가능)
            int x = rand.nextInt(700); // 0부터 700까지의 랜덤 x 좌표
            int y = rand.nextInt(300); // 0부터 300까지의 랜덤 y 좌표
            int hp = rand.nextInt(20) + 1; // 1부터 20까지의 랜덤 체력

            monsters.add(new Monster(x, y, hp));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Monster monster : monsters) {
            monster.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Monster Game");
        CatchGame mainPanel = new CatchGame();
        frame.add(mainPanel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        Iterator<Monster> iterator = monsters.iterator();
        while (iterator.hasNext()) {
            Monster monster = iterator.next();
            if (mouseX >= monster.x && mouseX <= monster.x + 50 && mouseY >= monster.y && mouseY <= monster.y + 50) {
                iterator.remove();
            }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}



