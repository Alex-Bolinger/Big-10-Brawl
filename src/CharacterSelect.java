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
    private JFrame player;
    private JComponent pComp;

    private Color startColor;
    private Color startTextColor;
    private Color joinColor;
    private Color joinTextColor;

    public CharacterSelect() {
        player = new JFrame();
        pComp = new JComponent() {
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
                g.fillRect(117,98,180,180);
                g.fillRect(346,98,180,180);
                g.fillRect(575,98,180,180);
                g.fillRect(804,98,180,180);
                g.fillRect(117,357,180,180);
                g.fillRect(346,357,180,180);
                g.fillRect(575,357,180,180);
                g.fillRect(804,357,180,180);
            }
        };
    }

    //return the int value of the player
    //use the selection in mouseReleased to determine which character was selected
    //dont hardcode the integers, use Character.<character_name>
    public int initFrame() {
        player.setSize(1550,838);
        player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player.setTitle("Character Select");
        player.add(pComp);
        player.addMouseListener(new MouseListener() {
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
            //when you fix the button selection to check for each button
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        player.setVisible(true);
    }

    public void changeButtonColor() {
        if (startColor.equals(new Color(63,188,239))) {
            startColor = new Color(255,255,255);
        } else {
            startColor = new Color(63,188,239);
        }
        player.repaint();
    }


}

