import javax.swing.*;

class Player extends Entity{

    Timer playerTurnLeft, playerTurnRight;
    private int speed;

    Player(int health, int width, int height, int speed) {
        super();

        Player player = this;

        player.setHealth(health);
        player.setWidth(width);
        player.setHeight(height);
        player.speed = speed;

        player.setIcon(changeImage("./img/player.png", width, height));
        player.setBounds(Main.mainFrame.getWidth() / 2 - width / 2, Main.mainFrame.getHeight() - height, width, height);

        playerTurnLeft = new Timer(5, e12 -> {
            if (player.getX() > 0) {
                player.setLocation(player.getX() - speed, player.getY());
            } else playerTurnLeft.stop();
        });
        playerTurnRight = new Timer(5, e12 -> {
            if (player.getX() <= Main.mainFrame.getWidth() - 120) {
                player.setLocation(player.getX() + speed, player.getY());
            } else playerTurnRight.stop();
        });
    }
}
