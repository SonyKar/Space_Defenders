import javax.swing.*;
import java.awt.*;

public class LaserBeam extends Entity {

  private int damage;
  Timer shooting;

  LaserBeam(int damage, int speed, Enemy[] enemy) {
    super();
    LaserBeam laser = this;

    this.setSpeed(speed);
    this.damage = damage;
    this.setIcon(changeImage("./img/laser.png", 15, 75));
    this.setSize(new Dimension(15, 75));

    shooting = new Timer(5, e -> {
        for (int i = 0; i < enemy.length; i++)
            if(checkHit(laser, enemy[i])) System.out.println("Enemy " + i + " hit"); // Check if out bullet hit an enemy
        if (laser.getY() > 10) {
            laser.setLocation(laser.getX(), laser.getY() - laser.getSpeed()); // Moving bullet up, until it gets to 10 y coordinate
        } else {
            laser.shooting.stop(); // If it gets to 10 y coordinate, then stop moving
        }
    });
  }

  private static boolean checkHit(LaserBeam bullet, Enemy enemy) {
    Rectangle shotEnemy = new Rectangle(enemy.getBounds());

    Rectangle checkRes = SwingUtilities.computeIntersection(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), shotEnemy);

    return (checkRes.getWidth() > 0 && checkRes.getHeight() > 0);
  }
}
