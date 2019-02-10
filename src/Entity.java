import javax.swing.*;
import java.awt.*;

public class Entity extends JLabel{
    private int width, height, speed;

    Entity() {
        super();
    }

    void setWidth(int width) { this.width = width; }

    void setHeight(int height) { this.height = height; }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    ImageIcon changeImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }


}
