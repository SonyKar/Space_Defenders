import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Levels extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(ImageIO.read(new File("./img/background.png")), 0, 0, Main.mainFrame.getWidth(), Main.mainFrame.getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Levels() {
        super();
        Main.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        Main.mainFrame.setFocusable(true);

        Player player = new Player(3, 100, 100, 10);
        this.add(player);

        Main.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.playerTurnRight.start();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.playerTurnLeft.start();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                player.playerTurnLeft.stop();
                player.playerTurnRight.stop();
            }
        });
    }
}
