import javax.swing.*;
import java.awt.*;

public class Main {
    static int score = 0;
    static JFrame mainFrame = new JFrame("Test Game");

//    start Textures

//    General
    static ImageIcon logo = new ImageIcon(new ImageIcon("./img/logo.png").getImage().getScaledInstance(390, 300, Image.SCALE_DEFAULT));

//    enemies
    static ImageIcon enemy1 = new ImageIcon(new ImageIcon("./img/enemy1.png").getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT));
    static ImageIcon enemy2 = new ImageIcon(new ImageIcon("./img/enemy2.png").getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT));
    static ImageIcon enemy2_damaged1 = new ImageIcon(new ImageIcon("./img/enemy2_damaged1.png").getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT));
    static ImageIcon explode = new ImageIcon(new ImageIcon("./img/explosion.png").getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT));

//    player
    static ImageIcon player = new ImageIcon(new ImageIcon("./img/player.png").getImage().getScaledInstance(75, 150, Image.SCALE_DEFAULT));
    static ImageIcon player_left = new ImageIcon(new ImageIcon("./img/player_left.png").getImage().getScaledInstance(75, 150, Image.SCALE_DEFAULT));
    static ImageIcon player_right = new ImageIcon(new ImageIcon("./img/player_right.png").getImage().getScaledInstance(75, 150, Image.SCALE_DEFAULT));

//    laser
    static ImageIcon laser = new ImageIcon(new ImageIcon("./img/laser.png").getImage().getScaledInstance(15, 75, Image.SCALE_DEFAULT));

//    end Textures

    static void changeScreen(Container container) {
        Main.mainFrame.getContentPane().removeAll();
        Main.mainFrame.setContentPane(container);
        refresh();
    }

    static void refresh() {
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static void main(String[] args) {

        mainFrame.setLocationByPlatform(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu menu = new Menu();

        mainFrame.setContentPane(menu);

        mainFrame.setPreferredSize(new Dimension(800, 600));
        mainFrame.pack();

        mainFrame.setVisible(true);

        menu.addButtons();

    }
}
