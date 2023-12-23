// Spaceship.java
package Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;  // Import List from java.util

class Spaceship {
    private int x, y;
    private Image image;
    private boolean movingUp;
    private boolean movingDown;
    private static final int SPACESHIP_SPEED = 5; // Set the speed

    public Spaceship() {
        this.image = new ImageIcon("spaceship.png").getImage();
        if (image.getWidth(null) < 0 || image.getHeight(null) < 0) {
            System.out.println("Failed to load spaceship image.");
        }
        this.x = 50;
        this.y = 250;
        this.movingUp = false;
        this.movingDown = false;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public void move() {
        if (movingUp) {
            y = Math.max(0, y - SPACESHIP_SPEED);
        } else if (movingDown) {
            y = Math.min(800 - image.getHeight(null), y + SPACESHIP_SPEED);
        }
    }

    public void fire(List<Missile> missiles) {
        missiles.add(new Missile(x + image.getWidth(null) / 2, y));
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
