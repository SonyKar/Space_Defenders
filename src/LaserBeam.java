import javax.swing.*;
import java.awt.*;

public class LaserBeam extends Entity {

  private int damage;

  LaserBeam(int damage) {
    super();

    this.damage = damage;
    this.setIcon(changeImage("./img/laser.png", 15, 75));
    this.setSize(new Dimension(15, 75));
  }

  public static boolean checkHit(LaserBeam bullet, Enemy enemy) {
    Rectangle shotEnemy = new Rectangle(enemy.getBounds());

    Rectangle checkRes = SwingUtilities.computeIntersection(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), shotEnemy);

    return (checkRes.getWidth() > 0 && checkRes.getHeight() > 0);
  }
}
