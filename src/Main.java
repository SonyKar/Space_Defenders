import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame mainFrame = new JFrame("Test Game");

    static void refresh(Container container) {
        Main.mainFrame.getContentPane().removeAll();
        Main.mainFrame.setContentPane(container);
        Main.mainFrame.getContentPane().revalidate();
        Main.mainFrame.getContentPane().repaint();
    }

    public static void main(String[] args) {

        mainFrame.setLocationByPlatform(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setContentPane(new Menu());

        mainFrame.setPreferredSize(new Dimension(600, 600));
        mainFrame.pack();

        mainFrame.setVisible(true);
    }
}
