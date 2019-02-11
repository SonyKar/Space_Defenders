import java.awt.*;

class Enemy extends Entity {
    private int health, type;

    Enemy(int type, int speed) {
        super();

        this.type = type;
        this.setWidth(50);
        this.setHeight(75);
        this.setSpeed(speed);

        switch (type) {
            case 1:
                this.setIcon(Main.enemy1);
                this.health = 1;
                break;
            case 2:
                this.setIcon(Main.enemy2);
                this.health = 2;
                break;
        }

        this.setSize(new Dimension(this.getWidth(), this.getHeight()));
    }

    boolean isDead() {
        if (this.health == 1) {
            return true;
        } else {
            switch(this.type){
                case 2:
                    this.health--;
                    this.setIcon(Main.enemy2_damaged1);
                    break;
            }
            return false;
        }
    }
}
