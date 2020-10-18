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
                g.fillRect(116,96,180,180);
            }
        };
    }
    public void initFrame() {
        player1.setSize(1550,838);
        player1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player1.setTitle("Character Select");
        player1.add(p1Comp);
        player1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.equals("d") || e.equals("D")) {

                } else if (e.equals("a") || e.equals("A")) {

                } else if (e.equals("w") || e.equals("W")) {

                } else if (e.equals("s") || e.equals("S")) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        player1.setVisible(true);

    }
}

