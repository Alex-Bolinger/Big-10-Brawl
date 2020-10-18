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
    private BufferedImage blueSquare;

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
                if (blueSquare == null) {
                    try {
                        blueSquare = ImageIO.read(new File("bin/Character Select/Character Sprites/Outline_Blue.png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                if (playerNumber > 1) {
                    if (player1Select == 0) {
                        g.drawImage(blueSquare,181,122,null);
                    } else if (player1Select == 1) {
                        g.drawImage(blueSquare,486,122,null);
                    } else if (player1Select == 4) {
                        g.drawImage(buckeye,181,466,null);
                    } else if (player1Select == 3) {
                        g.drawImage(blueSquare,1099,466,null);
                    } else if (player1Select == 2) {
                        g.drawImage(blueSquare,793,122,null);
                    } else if (player1Select == 5) {
                        g.drawImage(blueSquare,486,466,null);
                    } else if (player1Select == 6) {
                        g.drawImage(blueSquare,793,466,null);
                    } else if (player1Select == 7) {
                        g.drawImage(blueSquare,1099,122,null);
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
                g.fillRect(198,138,236,236);
                g.setColor(iowa);
                g.fillRect(504,138,236,236);
                g.setColor(wisconsin);
                g.fillRect(811,138,236,236);
                g.setColor(minnesota);
                g.fillRect(1117,138,236,236);
                g.setColor(osu);
                g.fillRect(198,484,236,236);
                g.setColor(msu);
                g.fillRect(504,484,236,236);
                g.setColor(michigan);
                g.fillRect(811,484,236,236);
                g.setColor(indiana);
                g.fillRect(1117,484,236,236);
                g.drawImage(pete,242,207,null);
                g.drawImage(hawkeye,546,231,null);
                g.drawImage(badger,844,210,null);
                g.drawImage(gopher,1151,209,null);
                g.drawImage(buckeye,232,548,null);
                g.drawImage(sparky,543,549,null);
                g.drawImage(wolverine,846,553,null);
                g.drawImage(hoosier,1174,471,null);
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
                if (e.getX() >= 198 && e.getX() <= 434 && e.getY() >= 138 && e.getY() <= 374) {
                    characterValue = 0;
                    player1Select = 0;
                    changePurdueButtonColor();
                } else if (e.getX() >= 504 && e.getX() <= 740 && e.getY() >= 138 && e.getY() <= 374) {
                    characterValue = 1;
                    player1Select = 1;
                    changeIowaButtonColor();
                } else if (e.getX() >= 811 && e.getX() <= 1047 && e.getY() >= 138 && e.getY() <= 374) {
                    characterValue = 2;
                    player1Select = 2;
                    changeWisconsinButtonColor();
                } else if (e.getX() >= 1117 && e.getX() <= 1353 && e.getY() >= 138 && e.getY() <= 374) {
                    characterValue = 7;
                    player1Select = 7;
                    changeMinnesotaButtonColor();
                } else if (e.getX() >= 198 && e.getX() <= 434 && e.getY() >= 484 && e.getY() <= 720) {
                    characterValue = 4;
                    player1Select = 4;
                    changeOSUButtonColor();
                } else if (e.getX() >= 504 && e.getX() <= 740 && e.getY() >= 484 && e.getY() <= 720) {
                    characterValue = 5;
                    player1Select = 5;
                    changeMSUButtonColor();
                } else if (e.getX() >= 811 && e.getX() <= 1047 && e.getY() >= 484 && e.getY() <= 720) {
                    characterValue = 6;
                    player1Select = 6;
                    changeMichiganButtonColor();
                } else if (e.getX() >= 1117 && e.getX() <= 1353 && e.getY() >= 484 && e.getY() <= 720) {
                    characterValue = 3;
                    player1Select = 3;
                    changeIndianaButtonColor();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 198 && e.getX() <= 434 && e.getY() >= 138 && e.getY() <= 374) {
                    changePurdueButtonColor();
                    finished = true;
                } else if (e.getX() >= 504 && e.getX() <= 740 && e.getY() >= 138 && e.getY() <= 374) {
                    changeIowaButtonColor();
                    finished = true;
                } else if (e.getX() >= 811 && e.getX() <= 1047 && e.getY() >= 138 && e.getY() <= 374) {
                    changeWisconsinButtonColor();
                    finished = true;
                } else if (e.getX() >= 1117 && e.getX() <= 1353 && e.getY() >= 138 && e.getY() <= 374) {
                    changeMinnesotaButtonColor();
                    finished = true;
                } else if (e.getX() >= 198 && e.getX() <= 434 && e.getY() >= 484 && e.getY() <= 720) {
                    changeOSUButtonColor();
                    finished = true;
                } else if (e.getX() >= 504 && e.getX() <= 740 && e.getY() >= 484 && e.getY() <= 720) {
                    changeMSUButtonColor();
                    finished = true;
                } else if (e.getX() >= 811 && e.getX() <= 1047 && e.getY() >= 484 && e.getY() <= 720) {
                    changeMichiganButtonColor();
                    finished = true;
                } else if (e.getX() >= 1117 && e.getX() <= 1353 && e.getY() >= 484 && e.getY() <= 720) {
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

