import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class CharacterSelect {
    private JFrame player1;
    private JComponent p1Comp;

    private Color startColor;
    private Color startTextColor;
    private Color joinColor;
    private Color joinTextColor;

    public CharacterSelect() {
        player1 = new JFrame();
        p1Comp = new JComponent() {
            private BufferedImage bg;

            public void paint(Graphics g) {
                //draw background here
                if (bg == null) {
                    try {
                        bg = ImageIO.read(new File("bin/Character Select/Character_Select_Player1.png"));
                    } catch (IOException e){
                        System.out.println("Stack Error");
                    }
                }
                g.drawImage(bg,0,0,null);
                if (startColor == null) {
                    startColor = new Color(63,188,239);
                }
                g.setColor(startColor);
                g.fillRect(119,100,180,180);
                g.fillRect(348,100,180,180);
                g.fillRect(577,100,180,180);
                g.fillRect(806,100,180,180);
                g.fillRect(119,539,180,180);
                g.fillRect(348,539,180,180);
                g.fillRect(577,539,180,180);
                g.fillRect(806,539,180,180);
            }
        };
    }
    public void initFrame() {
        player1.setSize(1550,838);
        player1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player1.setTitle("Character Select");
        player1.add(p1Comp);
        player1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 477 && e.getX() <= 753 && e.getY() >= 646 && e.getY() <= 757) {
                    changeButtonColor();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 477 && e.getX() <= 753 && e.getY() >= 646 && e.getY() <= 757) {
                    changeButtonColor();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        player1.setVisible(true);
    }

    public void changeButtonColor() {
        if (startColor.equals(new Color(63,188,239))) {
            startColor = new Color(255,255,255);
        } else {
            startColor = new Color(63,255,239);
        }
        player1.repaint();
    }
}

