import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class Big10Brawl {
    public static void main(String[] args) {
        Big10Brawl b10B = new Big10Brawl();
        b10B.initFrame();
    }

    private JFrame welcome;
    private JFrame waiting;
    private JComponent welComp;

    private Color startColor;
    private Color startTextColor;
    private Color joinColor;
    private Color joinTextColor;

    public Big10Brawl() {
        welcome = new JFrame();
        welComp = new JComponent() {
            private BufferedImage bg;



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
                g.fillRect(477,646,276,111);
                if (joinColor == null) {
                    joinColor = new Color(0,0,0);
                    joinTextColor = new Color(255, 255, 255);
                }
                g.setColor(joinColor);
                g.fillRect(797,646,276,111);
                g.setFont(new Font(Font.SERIF,Font.BOLD,40));
                g.setColor(startTextColor);
                g.drawString("Start", 570, 710);
                g.setColor(joinTextColor);
                g.drawString("Join", 895, 710);

            }
        };
    }

    public void initFrame() {
        welcome.setSize(1550,838);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setTitle("Big Ten Brawl");
        welcome.add(welComp);
        welcome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 477 && e.getX() <= 753 && e.getY() >= 646 && e.getY() <= 757) {
                    changeStartColor();
                } else if (e.getX() >= 797 && e.getX() <= 1073 && e.getY() >= 646 && e.getY() <= 757) {
                    changeJoinColor();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 477 && e.getX() <= 753 && e.getY() >= 646 && e.getY() <= 757) {
                    changeStartColor();
                    startWaiting();
                } else if (e.getX() >= 797 && e.getX() <= 1073 && e.getY() >= 646 && e.getY() <= 757) {
                    changeJoinColor();
                    join();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        welcome.setVisible(true);

    }

    public void changeStartColor() {
        if (startColor.equals(new Color(0,0,0))) {
            startColor = new Color(255,255,255);
            startTextColor = new Color(0,0,0);
        } else {
            startColor = new Color(0,0,0);
            startTextColor = new Color(255,255,255);
        }
        welcome.repaint();
    }

    public void changeJoinColor() {
        if (joinColor.equals(new Color(0,0,0))) {
            joinColor = new Color(255,255,255);
            joinTextColor = new Color(0,0,0);
        } else {
            joinColor = new Color(0,0,0);
            joinTextColor = new Color(255,255,255);
        }
        welcome.repaint();
    }

    public void startWaiting() {
        welcome.setVisible(false);
        waiting = new JFrame();
        waiting.setSize(1550,838);
        waiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        waiting.setTitle("Big Ten Brawl");
        waiting.setVisible(true);
    }

    public void join() {
        String ip = JOptionPane.showInputDialog("Enter IP of other player");
    }
}
