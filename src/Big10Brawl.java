import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Big 10 Brawl
 *
 * <p>A battle between the mascots of some of the Big 10 schools</p>
 *
 * @author Brass Hax
 * @version September 17, 2020
 */

public class Big10Brawl {
    public static void main(String[] args) {
        Big10Brawl b10B = new Big10Brawl();
        b10B.initFrame();
    }

    private JFrame welcome;
    private JFrame playerSelect;
    private JComponent welComp;

    private Color startColor;
    private Color startTextColor;

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
                g.fillRect(637,645,276,111);
                g.setFont(new Font(Font.SERIF,Font.BOLD,40));
                g.setColor(startTextColor);
                g.drawString("Start", 570, 710);

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
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 477 && e.getX() <= 753 && e.getY() >= 646 && e.getY() <= 757) {
                    changeStartColor();
                    startSelectionScreen();
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


    //changes the color of the start button
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

    public void startSelectionScreen() {
        CharacterSelect cs1 = new CharacterSelect();
        cs1.initFrame();
    }
}
