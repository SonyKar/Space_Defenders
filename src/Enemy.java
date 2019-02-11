import javax.swing.*;
import java.awt.*;

class Enemy extends Entity {
    private Boolean isEnd;
    private int health;

    private Timer movingEnemies;

    Enemy(int health, int speed) {
        super();

        this.health = health;
        this.setWidth(50);
        this.setHeight(75);
        this.setSpeed(speed);

        switch (health) {
            case 1:
                this.setIcon(changeImage("img/enemy1.png", this.getWidth(), this.getHeight()));
                break;
            case 2:
                this.setIcon(changeImage("img/enemy2.png", this.getWidth(), this.getHeight()));
                break;
        }

        this.setSize(new Dimension(this.getWidth(), this.getHeight()));
    }

    void moveEnemy(Enemy[] enemy, int enemyCount) {
        movingEnemies = new Timer(5, e -> {
            if (enemy[0].getX() == 700) isEnd = true;
            else if (enemy[0].getX() == 0) isEnd = false;
            if (!isEnd) {
                for(int i = 0; i < enemyCount; i++) {
                    enemy[i].setLocation(enemy[i].getX() + enemy[i].getSpeed(), enemy[i].getY());
                }
            }
            else if(isEnd) {
                for(int i = 0; i < enemyCount; i++) {
                    enemy[i].setLocation(enemy[i].getX() - enemy[i].getSpeed(), enemy[i].getY());
                }
            }
            else movingEnemies.stop();
        });

        movingEnemies.start();
    }
}
