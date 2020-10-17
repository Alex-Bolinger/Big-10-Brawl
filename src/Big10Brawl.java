import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Big10Brawl {
    public static void main(String[] args) {
        Big10Brawl b10B = new Big10Brawl();
        b10B.initFrame();
    }

    private JFrame welcome;
    private JFrame waiting;

    public Big10Brawl() {
        welcome = new JFrame();
    }

    public void initFrame() {
        welcome.setSize(1550,838);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setTitle("Big Ten Brawl");
        welcome.add(new JComponent() {
            private Color startColor;
            private Color startTextColor;
            private Color joinColor;
            private Color joinTextColor;
            private BufferedImage bg;

            public void changeStartColor() {
                if (startColor.equals(new Color(0,0,0))) {
                    startColor = new Color(255,255,255);
                    startTextColor = new Color(0,0,0);
                } else {
                    startColor = new Color(0,0,0);
                    startTextColor = new Color(255,255,255);
                }
            }

            public void changeJoinColor() {
                if (joinColor.equals(new Color(0,0,0))) {
                    joinColor = new Color(255,255,255);
                    joinTextColor = new Color(0,0,0);
                } else {
                    joinColor = new Color(0,0,0);
                    joinTextColor = new Color(255,255,255);
                }
            }

            public void paint(Graphics g) {
                //draw background here
                if (bg == null) {
                    try {
                        bg = ImageIO.read(new File("bin/Big_Ten_Brawl_Menu.png"));
                    } catch (IOException e){
                        System.out.println("Stack Error");
                    }
                }
                g.drawImage(bg,0,0,null);
                if (startColor == null) {
                    startColor = new Color(0,0,0);
                    startTextColor = new Color(255,255,255);
                }
                g.setColor(startColor);
                g.fillRect(0,0,100,50);
                if (joinColor == null) {
                    joinColor = new Color(0,0,0);
                    joinTextColor = new Color(255, 255, 255);

                }
                g.setColor(joinColor);
                g.fillRect(0,0,100,50);


                g.setColor(startTextColor);
                g.drawString("Start", 0, 0);

                g.setColor(joinTextColor);
                g.drawString("Join", 0, 0);

            }
        });
        welcome.setVisible(true);

    }

    public void startWaiting() {
        waiting = new JFrame();
        waiting.setSize(1550,838);
        waiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waiting.setTitle("Big Ten Brawl");
        welcome.setVisible(true);
    }
}
