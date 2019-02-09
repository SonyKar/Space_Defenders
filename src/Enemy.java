import javax.swing.*;

class Enemy extends Entity {
    private Boolean isEnd;
    private int health;

    private Timer movingEnemies;

    Enemy(int health, int width, int height, int speed) {
        super();

        this.health = health;
        this.setWidth(width);
        this.setHeight(height);
        this.setSpeed(speed);

        switch (health) {
            case 1:
                this.setIcon(changeImage("img/spaceInvader.png", width, height));
                break;
        }
    }

    void moveEnemy(Enemy[] enemy, int n) {
        movingEnemies = new Timer(5, e -> {
            if (enemy[0].getX() == 700) isEnd = true;
            else if (enemy[0].getX() == 0) isEnd = false;
            if (!isEnd) {
                for(int i = 0; i < n; i++) {
                    enemy[i].setLocation(enemy[i].getX() + enemy[i].getSpeed(), enemy[i].getY());
                }
            }
            else if(isEnd) {
                for(int i = 0; i < n; i++) {
                    enemy[i].setLocation(enemy[i].getX() - enemy[i].getSpeed(), enemy[i].getY());
                }
            }
            else movingEnemies.stop();
        });

        movingEnemies.start();
    }
}
