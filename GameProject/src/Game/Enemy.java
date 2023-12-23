// Enemy.java
package Game;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x, y;
    private Image image;

    public Enemy(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
        this.image = new ImageIcon("enemy.png").getImage();
        if (image.getWidth(null) < 0 || image.getHeight(null) < 0) {
            System.out.println("Failed to load enemy image.");
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void move() {
        x -= 5; // Move from right to left
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    public boolean isHitByMissile(Missile missile) {
        return getBounds().intersects(missile.getBounds());
    }
}
