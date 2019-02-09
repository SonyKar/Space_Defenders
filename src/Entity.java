import javax.swing.*;
import java.awt.*;

public class Entity extends JLabel{
    private int health, width, height;

    Entity() {
        super();
    }

    public int getHealth() { return health; }

    void setHealth(int health) { this.health = health; }

    void setWidth(int width) { this.width = width; }

    void setHeight(int height) { this.height = height; }

    ImageIcon changeImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
