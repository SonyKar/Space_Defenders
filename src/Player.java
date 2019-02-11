import javax.swing.*;

class Player extends Entity{

    Timer playerTurnLeft, playerTurnRight;

    Player(int speed) {
        super();

        this.setWidth(75);
        this.setHeight(150);
        this.setSpeed(speed);

        this.setIcon(Main.player);
        this.setBounds(Main.mainFrame.getWidth() / 2 - this.getWidth() / 2, Main.mainFrame.getHeight() - this.getHeight() - 50, this.getWidth(), this.getHeight());

        Player player = this;
        playerTurnLeft = new Timer(5, e12 -> {
            if (player.getX() > 0) {
                player.setLocation(player.getX() - speed, player.getY());
            } else playerTurnLeft.stop();
        });
        playerTurnRight = new Timer(5, e12 -> {
            if (player.getX() <= Main.mainFrame.getWidth() - player.getWidth() - 20) {
                player.setLocation(player.getX() + speed, player.getY());
            } else playerTurnRight.stop();
        });
    }

    void shoot(LaserBeam laser) {
        laser.setLocation(this.getX() + this.getWidth() / 2, this.getY() - 30);
        this.getParent().add(laser);
        laser.shooting.start();
    }
}
