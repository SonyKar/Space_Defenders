import javax.swing.*;
import java.awt.*;

class LaserBeam extends Entity {

  private int damage;
  Timer shooting;

  LaserBeam(int damage, int speed) {
    super();

    this.setSpeed(speed);
    this.damage = damage;
    this.setWidth(15);
    this.setHeight(75);

    this.setIcon(Main.laser);
    this.setSize(new Dimension(this.getWidth(), this.getHeight()));

    LaserBeam laser = this;
    shooting = new Timer(5, e -> {
        for (int i = 0; i < Levels.enemy.size(); i++)
            if(checkHit(laser, Levels.enemy.get(i))) {
                Enemy currentEnemy = Levels.enemy.get(i); // getting enemy which was damaged

//                Adding score
                Main.score += 100;
                Levels.score.setText("Score " + Main.score);

                laser.getParent().remove(laser); // removing laser from screen

                if (currentEnemy.isDead()) {
                    currentEnemy.setIcon(Main.explode);
                    Main.refresh();
                    Levels.enemy.remove(i);
                    new Thread(() -> {
                        try  { Thread.sleep( 1000 ); }
                        catch (InterruptedException ie)  { ie.printStackTrace(); }
                        currentEnemy.getParent().remove(currentEnemy);
                        Main.refresh();
                    }).start();
                } else {
                    Main.refresh();
                }

                laser.shooting.stop();
            }
        if (laser.getY() > -laser.getHeight()) {
            laser.setLocation(laser.getX(), laser.getY() - laser.getSpeed()); // Moving bullet up, until it gets to 10 y coordinate
        } else {
            laser.shooting.stop(); // If it gets to 10 y coordinate, then stop moving
            laser.getParent().remove(laser);
        }
    });
  }

  private static boolean checkHit(LaserBeam bullet, Enemy enemy) {
    Rectangle shotEnemy = new Rectangle(enemy.getBounds());

    Rectangle checkRes = SwingUtilities.computeIntersection(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), shotEnemy);

    return (checkRes.getWidth() > 0 && checkRes.getHeight() > 0);
  }
}
