import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Menu extends JPanel{

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(ImageIO.read(new File("./img/menuBackground.jpg")), 0, 0, 600, 600,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Menu() {
        super();

        Main.mainFrame.pack();
        this.setSize(new Dimension(600, 600));

        this.setLayout(null);

        JButton start = new JButton("Start");
        start.setFocusPainted(false);
        start.setBounds(getWidth()/2 - 45, getHeight()/2 - 60, 80, 35);
        start.setContentAreaFilled(false);
        start.setBackground(Color.green);
        start.setForeground(Color.black);
        start.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.changeScreen(new Level1());
            }
        });
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                start.setContentAreaFilled(true);
                start.setForeground(Color.white);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                start.setContentAreaFilled(false);
                start.setForeground(Color.black);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JButton exit = new JButton("Exit");
        exit.setFocusPainted(false);
        exit.setBounds(getWidth()/2 - 45, getHeight()/2 - 20, 80, 35);
        exit.setContentAreaFilled(false);
        exit.setBackground(Color.red);
        exit.setForeground(Color.black);
        exit.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exit.setContentAreaFilled(true);
                exit.setForeground(Color.white);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                exit.setContentAreaFilled(false);
                exit.setForeground(Color.black);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        this.add(start);
        this.add(exit);
    }
}
