import javax.swing.*;

class Enemy extends Entity {
    private Boolean isEnd;

    Timer movingEnemies;

    Enemy(int health, int width, int height) {
        super();

        this.setHealth(health);
        this.setWidth(width);
        this.setHeight(height);

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
                    enemy[i].setLocation(enemy[i].getX() + 1, enemy[i].getY());
                }
            }
            else if(isEnd) {
                for(int i = 0; i < n; i++) {
                    enemy[i].setLocation(enemy[i].getX() - 1, enemy[i].getY());
                }
            }
            else movingEnemies.stop();
        });

        movingEnemies.start();
    }
}
