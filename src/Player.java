import javax.swing.*;

class Player extends Entity{

    Timer playerTurnLeft, playerTurnRight;

    Player(int speed) {
        super();

        Player player = this;

        player.setWidth(75);
        player.setHeight(150);
        player.setSpeed(speed);

        player.setIcon(changeImage("./img/player.png", player.getWidth(), player.getHeight()));
        player.setBounds(Main.mainFrame.getWidth() / 2 - player.getWidth() / 2, Main.mainFrame.getHeight() - player.getHeight() - 50, player.getWidth(), player.getHeight());

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
