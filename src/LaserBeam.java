import javax.swing.*;
import java.awt.*;

public class LaserBeam extends JLabel {

  private int width = 10, height = 30, damage;

  LaserBeam(int damage) {
    ImageIcon laserBeam = new ImageIcon(new ImageIcon("../img/laser.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    setDamage(damage);
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
}
