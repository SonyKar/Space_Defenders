import javax.swing.*;
import java.awt.*;

public class LaserBeam extends JLabel {

  private int width = 10, height = 30, damage;

  LaserBeam(int damage) {
    super();
    ImageIcon laserBeam = new ImageIcon(new ImageIcon("../img/laser.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    setDamage(damage);
    this.setIcon(laserBeam);
    this.setSize(new Dimension(15, 75));
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public static boolean ceckHit(JLabel Bullet, JLabel Enemy) {

    Rectangle shotEnemy = new Rectangle(Enemy.getBounds());
    Rectangle checkRes = SwingUtilities.computeIntersection(Bullet.getX(), Bullet.getY(), Bullet.getWidth(), Bullet.getHeight(), shotEnemy);

    return (checkRes.getWidth() > 0 && checkRes.getHeight() > 0);
  }
}
