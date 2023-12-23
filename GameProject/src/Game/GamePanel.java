// GamePanel.java
package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GamePanel extends JPanel {
    private List<Enemy> enemies;
    private List<Missile> missiles;
    private Spaceship spaceship;
    private int score;
    private long startTime;
    private boolean gameRunning;
    private GalagaGame galagaGame;

    public GamePanel(GalagaGame galagaGame) {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        this.galagaGame = galagaGame; // Assign the GalagaGame instance

        spaceship = new Spaceship();
        enemies = new ArrayList<>();
        missiles = new ArrayList<>();
        gameRunning = false;

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new SpaceshipControl());
    }

    public void startGame() {
        if (gameRunning) return;

        startTime = System.currentTimeMillis();
        score = 0;
        gameRunning = true;

        enemies.clear();
        for (int i = 0; i < 5; i++) {
            int initialX = 800 + i * 100; // Start enemies at different positions
            int initialY = (int) (Math.random() * 500);
            enemies.add(new Enemy(initialX, initialY));
        }

        // 스레드로 게임 업데이트 동작
        new Thread(() -> {
            while (gameRunning) {
                gameUpdate();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void gameUpdate() {
        if (!gameRunning) return;

        spaceship.move();
        updateGameObjects();
        checkCollisions();

        repaint();
    }

    private void updateGameObjects() {
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            enemy.move();
            if (enemy.getBounds().intersects(spaceship.getBounds())) {
                endGame();
            }

            Iterator<Missile> missileIterator = missiles.iterator();
            while (missileIterator.hasNext()) {
                Missile missile = missileIterator.next();
                missile.move();

                if (missile.isOffScreen()) {
                    missileIterator.remove();
                } else {
                    if (enemy.isHitByMissile(missile)) {
                        missileIterator.remove();
                        enemyIterator.remove();
                        score += 1;
                        updateScoreLabel();
                    }
                }
            }
        }

        // 추가: 적 생성
        if (Math.random() < 0.02) { // Adjust the probability as needed
            int initialX = 800;
            int initialY = (int) (Math.random() * 500);
            enemies.add(new Enemy(initialX, initialY));
        }
    }

    private void updateScoreLabel() {
        galagaGame.setScoreLabel("Score: " + score);
    }

    private void checkCollisions() {
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (enemy.getBounds().intersects(spaceship.getBounds())) {
                endGame();
            }
        }
    }

    private void endGame() {
        gameRunning = false;
        Timer gameTimer = galagaGame.getGameTimer();
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameRunning) {
            return;
        }

        spaceship.draw(g);
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
        for (Missile missile : missiles) {
            missile.draw(g);
        }
    }

    private class SpaceshipControl extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                spaceship.setMovingUp(true);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                spaceship.setMovingDown(true);
            } else if (keyCode == KeyEvent.VK_SPACE) {
                spaceship.fire(missiles);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                spaceship.setMovingUp(false);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                spaceship.setMovingDown(false);
            }
        }
    }
}
