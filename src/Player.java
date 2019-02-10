import javax.swing.*;

class Player extends Entity{

    Timer playerTurnLeft, playerTurnRight;

    Player(int width, int height, int speed) {
        super();

        Player player = this;

        player.setWidth(width);
        player.setHeight(height);
        player.setSpeed(speed);

        player.setIcon(changeImage("./img/player.png", width, height));
        player.setBounds(Main.mainFrame.getWidth() / 2 - width / 2, Main.mainFrame.getHeight() - height - 50, width, height);

        playerTurnLeft = new Timer(5, e12 -> {
            if (player.getX() > 0) {
                player.setLocation(player.getX() - speed, player.getY());
            } else playerTurnLeft.stop();
        });
        playerTurnRight = new Timer(5, e12 -> {
            if (player.getX() <= Main.mainFrame.getWidth() - width - 20) {
                player.setLocation(player.getX() + speed, player.getY());
            } else playerTurnRight.stop();
        });
    }

    void shoot(LaserBeam laser) {
        laser.setLocation(this.getX() + this.getWidth() / 2, this.getY() - 30);
        this.getParent().add(laser);
        laser.shooting.start();
        laser = null;
    }
}
