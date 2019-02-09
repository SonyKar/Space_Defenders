class Player extends Entity{

    Player(int health, int width, int height) {
        super();

        this.setHealth(health);
        this.setWidth(width);
        this.setHeight(height);

        this.setIcon(changeImage("./img/player.png", width, height));
        this.setBounds(Main.mainFrame.getWidth() / 2 - width / 2, Main.mainFrame.getHeight() - height, width, height);
    }
}
