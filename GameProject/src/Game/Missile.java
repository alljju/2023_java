package Game;

import javax.swing.*;
import java.awt.*;

class Missile {
    private int x, y;
    private Image image;
    private final int SPEED = 10;

    public Missile(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = new ImageIcon("missile.png").getImage();
        if (image.getWidth(null) < 0 || image.getHeight(null) < 0) {
            System.out.println("Failed to load missile image.");
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void move() {
        x += SPEED;
    }

    public boolean isOffScreen() {
        return y < -image.getHeight(null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}

