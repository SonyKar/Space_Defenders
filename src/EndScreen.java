import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class EndScreen extends JPanel {

   protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     try {
       g.drawImage(ImageIO.read(new File("./img/winBackground.png")), 0, 0, this.getWidth(), this.getHeight(), null);
     } catch (Exception e) {
       e.printStackTrace();
     }
   }

    EndScreen(String screenType) {
      super();
      this.setSize(new Dimension(1366, 768));

      switch (screenType) {
          case "success":
              this.setLayout(null);
//            JLabel succBack = new JLabel();
//            succBack.setBounds(0, 0, this.getWidth(), this.getHeight());
//            succBack.setIcon(Main.logo);
            JLabel ScoreStats = new JLabel("Your score: " + Main.score);
            ScoreStats.setBounds(550,300, 300, 100);
            ScoreStats.setFont(ScoreStats.getFont().deriveFont(30f));
            ScoreStats.setForeground(Color.white);
//            JButton NextLVL = new JButton("Next mission");
//            NextLVL.setBounds(this.getWidth()/3,this.getHeight()/3,100,50);
//            this.add(succBack);
            this.add(ScoreStats);
//            this.add(NextLVL);
            JButton BackToMenu = new JButton("Back to main");
            BackToMenu.setFocusPainted(false);
            BackToMenu.setBounds(640, 400, 80, 35);
            BackToMenu.setContentAreaFilled(false);
            BackToMenu.setBackground(new Color(0, 170, 196));
            BackToMenu.setForeground(Color.white);
            BackToMenu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 170, 196)));
            BackToMenu.addActionListener(e -> Main.changeScreen(new Menu()));
            BackToMenu.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                BackToMenu.setContentAreaFilled(true);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
              }
              public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                BackToMenu.setContentAreaFilled(false);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              }
              public void mousePressed(MouseEvent e) {
                BackToMenu.setContentAreaFilled(false);
              }
            });

            this.add(BackToMenu);

            break;

//          case "failure":
//            JLabel failBack = new JLabel();
//            failBack.setBounds(0, 0, this.getWidth(), this.getHeight());
//            failBack.setIcon(Main.logo);
//            JButton RetryLVL = new JButton("Next mission");
//
//            this.add(failBack);
//            this.add(RetryLVL);
//            break;
        }

    }
}
