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
    private int player1Select;

    private BufferedImage pete;
    private BufferedImage hawkeye;
    private BufferedImage badger;
    private BufferedImage gopher;
    private BufferedImage buckeye;
    private BufferedImage sparky;
    private BufferedImage wolverine;
    private BufferedImage hoosier;

    public boolean finished;


    public CharacterSelect(int playerNumber, int player1Select) {
        if (playerNumber == 1) {
            this.player1Select = 0;
        } else {

        }
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
                if (pete == null) {
                    try {
                        pete = ImageIO.read(new File("bin/Character Select/Character Sprites/Purdue_Pete_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (hawkeye == null) {
                    try {
                        hawkeye = ImageIO.read(new File("bin/Character Select/Character Sprites/Herky_Hawk_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (badger == null) {
                    try {
                        badger = ImageIO.read(new File("bin/Character Select/Character Sprites/Badgy_Badger_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (gopher == null) {
                    try {
                        gopher = ImageIO.read(new File("bin/Character Select/Character Sprites/Goldy_Gopher_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (buckeye == null) {
                    try {
                        buckeye = ImageIO.read(new File("bin/Character Select/Character Sprites/Brutus_Buckeye_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (sparky == null) {
                    try {
                        sparky = ImageIO.read(new File("bin/Character Select/Character Sprites/MSU_Sparty_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (wolverine == null) {
                    try {
                        wolverine = ImageIO.read(new File("bin/Character Select/Character Sprites/Michigan_Wolverine_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (hoosier == null) {
                    try {
                        hoosier = ImageIO.read(new File("bin/Character Select/Character Sprites/IU_Hoosier_Small.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (playerNumber > 1) {
                    if (player1Select == 0) {
                        g.drawImage(pete,313,671,null);
                    } else if (player1Select == 1) {
                        g.drawImage(hawkeye,313,696,null);
                    } else if (player1Select == 4) {
                        g.drawImage(buckeye,303,669,null);
                    } else if (player1Select == 3) {
                        g.drawImage(hoosier,352,662,null);
                    } else if (player1Select == 2) {
                        g.drawImage(badger,321,674,null);
                    } else if (player1Select == 5) {
                        g.drawImage(sparky,333,667,null);
                    } else if (player1Select == 6) {
                        g.drawImage(wolverine,326,671,null);
                    } else if (player1Select == 7) {
                        g.drawImage(gopher,337,673,null);
                    }
                }
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
                g.drawImage(pete,130,112,null);
                g.drawImage(hawkeye,352,136,null);
                g.drawImage(badger,580,114,null);
                g.drawImage(gopher,809,114,null);
                g.drawImage(buckeye,123,366,null);
                g.drawImage(sparky,359,367,null);
                g.drawImage(wolverine,579,371,null);
                g.drawImage(hoosier,824,362,null);
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
                    player1Select = 0;
                    changePurdueButtonColor();
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 1;
                    player1Select = 1;
                    changeIowaButtonColor();
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 2;
                    player1Select = 2;
                    changeWisconsinButtonColor();
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 111 && e.getY() <= 310) {
                    characterValue = 7;
                    player1Select = 7;
                    changeMinnesotaButtonColor();
                } else if (e.getX() >= 117 && e.getX() <= 297 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 4;
                    player1Select = 4;
                    changeOSUButtonColor();
                } else if (e.getX() >= 346 && e.getX() <= 526 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 5;
                    player1Select = 5;
                    changeMSUButtonColor();
                } else if (e.getX() >= 575 && e.getX() <= 756 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 6;
                    player1Select = 6;
                    changeMichiganButtonColor();
                } else if (e.getX() >= 804 && e.getX() <= 984 && e.getY() >= 369 && e.getY() <= 568) {
                    characterValue = 3;
                    player1Select = 3;
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

