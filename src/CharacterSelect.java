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

    private Color purdue;
    private Color iowa;
    private Color wisconsin;
    private Color minnesota;
    private Color osu;
    private Color msu;
    private Color michigan;
    private Color indiana;

    private int characterValue;

    public boolean finished;


    public CharacterSelect(int playerNumber) {
        finished = false;
        player1 = new JFrame();
        p1Comp = new JComponent() {
            private BufferedImage bg;

            public void paint(Graphics g) {
                //draw background here
                if (bg == null) {
                    try {
                        bg = ImageIO.read(new File("bin/Character Select/Character_Select_Player" + playerNumber + ".png"));
                    } catch (IOException e){
                        System.out.println("Stack Error");
                    }
                }
                g.drawImage(bg,0,0,null);
                if (purdue == null) {
                    purdue = new Color(63,188,239);
                    iowa = new Color(63,188,239);
                    wisconsin = new Color(63,188,239);
                    minnesota = new Color(63,188,239);
                    osu = new Color(63,188,239);
                    msu = new Color(63,188,239);
                    michigan = new Color(63,188,239);
                    indiana = new Color(63,188,239);
                }

                g.setColor(purdue);
                g.fillRect(117,98,180,180);

                g.setColor(iowa);
                g.fillRect(346,98,180,180);
                g.setColor(wisconsin);
                g.fillRect(575,98,180,180);
                g.setColor(minnesota);
                g.fillRect(804,98,180,180);
                g.setColor(osu);
                g.fillRect(117,357,180,180);
                g.setColor(msu);
                g.fillRect(346,357,180,180);
                g.setColor(michigan);
                g.fillRect(575,357,180,180);
                g.setColor(indiana);
                g.fillRect(804,357,180,180);
            }
        };
        player1.setSize(1550,838);
        player1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player1.setTitle("Character Select");
        player1.add(p1Comp);
        p1Comp.repaint();
        player1.repaint();
    }

    //return the int value of the player
    //use the selection in mouseReleased to determine which character was selected
    //dont hardcode the integers, use Character.<character_name>

    public void initFrame() {
        player1.setVisible(true);
        player1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 117 && e.getX() <= 297 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 0;
                    changePurdueButtonColor();
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 1;
                    changeIowaButtonColor();
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 2;
                    changeWisconsinButtonColor();
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 7;
                    changeMinnesotaButtonColor();
                } else if (e.getX() >= 117 && e.getX() <= 297 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 4;
                    changeOSUButtonColor();
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 5;
                    changeMSUButtonColor();
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 6;
                    changeMichiganButtonColor();
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 3;
                    changeIndianaButtonColor();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 117 && e.getX() <= 297 && e.getY() >= 111 && e.getY() <= 310) {
                    changePurdueButtonColor();
                    finished = true;
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 111 && e.getY() <= 310) {
                    changeIowaButtonColor();
                    finished = true;
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 111 && e.getY() <= 310) {
                    changeWisconsinButtonColor();
                    finished = true;
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 111 && e.getY() < 310) {
                    changeMinnesotaButtonColor();
                    finished = true;
                } else if (e.getX() >= 117 && e.getX() <= 297 && e.getY() >= 369 && e.getY() <= 568) {
                    changeOSUButtonColor();
                    finished = true;
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 369 && e.getY() <= 568) {
                    changeMSUButtonColor();
                    finished = true;
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 369 && e.getY() <= 568) {
                    changeMichiganButtonColor();
                    finished = true;
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 369 && e.getY() <= 568) {
                    changeIndianaButtonColor();
                    finished = true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void close() {
        player1.setVisible(false);
    }

    public int getCharacterValue() {
        return characterValue;
    }

    public void changePurdueButtonColor() {
        if (purdue.equals(new Color(63,188,239))) {
            purdue = new Color(255,255,255);
        } else {
            purdue = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeIowaButtonColor() {
        if (iowa.equals(new Color(63,188,239))) {
            iowa = new Color(255,255,255);
        } else {
            iowa = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeMinnesotaButtonColor() {
        if (minnesota.equals(new Color(63,188,239))) {
            minnesota = new Color(255,255,255);
        } else {
            minnesota = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeWisconsinButtonColor() {
        if (wisconsin.equals(new Color(63,188,239))) {
            wisconsin = new Color(255,255,255);
        } else {
            wisconsin = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeOSUButtonColor() {
        if (osu.equals(new Color(63,188,239))) {
            osu = new Color(255,255,255);
        } else {
            osu = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeMSUButtonColor() {
        if (msu.equals(new Color(63,188,239))) {
            msu = new Color(255,255,255);
        } else {
            msu = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeMichiganButtonColor() {
        if (michigan.equals(new Color(63,188,239))) {
            michigan = new Color(255,255,255);
        } else {
            michigan = new Color(63,188,239);
        }
        player1.repaint();
    }

    public void changeIndianaButtonColor() {
        if (indiana.equals(new Color(63,188,239))) {
            indiana = new Color(255,255,255);
        } else {
            indiana = new Color(63,188,239);
        }
        player1.repaint();
    }
}

