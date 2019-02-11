import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Levels extends JPanel {
    static ArrayList<Enemy> enemy = new ArrayList<>();
    private Timer movingEnemies;
    private boolean isEnd;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(ImageIO.read(new File("./img/background.png")), 0, 0, Main.mainFrame.getWidth(), Main.mainFrame.getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void moveEnemy() {
        movingEnemies = new Timer(5, e -> {
            if(Levels.enemy.size() != 0) {
                if (Levels.enemy.get(Levels.enemy.size() - 1).getX() >= Levels.enemy.get(Levels.enemy.size() - 1).getParent().getWidth() - Levels.enemy.get(Levels.enemy.size() - 1).getWidth()) isEnd = true;
                else if (Levels.enemy.get(0).getX() <= 0) isEnd = false;
                if (!isEnd) {
                    for(int i = 0; i < Levels.enemy.size(); i++) {
                        Levels.enemy.get(i).setLocation(Levels.enemy.get(i).getX() + Levels.enemy.get(i).getSpeed(), Levels.enemy.get(i).getY());
                    }
                }
                else if(isEnd) {
                    for(int i = 0; i < Levels.enemy.size(); i++) {
                        Levels.enemy.get(i).setLocation(Levels.enemy.get(i).getX() - Levels.enemy.get(i).getSpeed(), Levels.enemy.get(i).getY());
                    }
                }
            }
            else movingEnemies.stop();
        });

        movingEnemies.start();
    }

    Levels() {
        super();

        Main.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        Main.mainFrame.setFocusable(true);

        Player player = new Player(10);
        this.add(player);

        Main.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.playerTurnRight.start();
                    player.setIcon(Main.player_right);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.playerTurnLeft.start();
                    player.setIcon(Main.player_left);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.playerTurnRight.stop();
                    player.setIcon(Main.player);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.playerTurnLeft.stop();
                    player.setIcon(Main.player);
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    player.shoot(new LaserBeam(1, 10));
                }
            }
        });
    }
}
