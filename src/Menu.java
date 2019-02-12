import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Menu extends JPanel{

    JButton start = new JButton("Start");
    JButton exit = new JButton("Exit");

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            g.drawImage(ImageIO.read(new File("./img/menuBackground.jpg")), 0, 0, 800, 600,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addButtons() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.add(start);
        Main.refresh();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.add(exit);
        Main.refresh();
    }

    Menu() {
        super();

        Main.mainFrame.pack();
        this.setSize(new Dimension(800, 600));

        this.setLayout(null);

        JLabel logo1 = new JLabel("Space");
        logo1.setBounds(Main.mainFrame.getWidth() / 2, 20, 390, 300);
        this.add(logo1);

        start.setFocusPainted(false);
        start.setBounds(getWidth()/2 - 45, getHeight()/2 - 60, 80, 35);
        start.setContentAreaFilled(false);
        start.setBackground(new Color(0, 170, 196));
        start.setForeground(Color.white);
        start.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 170, 196)));

        start.addActionListener(e -> Main.changeScreen(new Level1()));
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                start.setContentAreaFilled(true);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                start.setContentAreaFilled(false);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            public void mousePressed(MouseEvent e) {
                start.setContentAreaFilled(false);
            }
        });

        exit.setFocusPainted(false);
        exit.setBounds(getWidth()/2 - 45, getHeight()/2 - 20, 80, 35);
        exit.setContentAreaFilled(false);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        exit.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));

        exit.addActionListener(e -> System.exit(0));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exit.setContentAreaFilled(true);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                exit.setContentAreaFilled(false);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            public void mousePressed(MouseEvent e) {
                exit.setContentAreaFilled(false);
            }
        });
    }
}
