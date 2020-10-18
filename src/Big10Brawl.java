import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }

    private JFrame welcome;
    private JFrame playerSelect;
    private JComponent welComp;
    private BufferedImage icon;

    private Player player1;
    private Player player2;

    private Color startColor;
    private Color startTextColor;

    private Timer checkStarted;
    private boolean started;

    private Timer checkPlayer1Chosen;

    private Timer checkPlayer2Chosen;

    private CharacterSelect cs1;
    private CharacterSelect cs2;

    public Big10Brawl() {
        welcome = new JFrame();
        if (icon == null) {
            try {
                icon = ImageIO.read(new File("bin/Frame_Icon_Image.png"));
            } catch (IOException e) {
                System.out.println("Stack error");
            }
        }
        welcome.setIconImage(icon);
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
                g.fillRect(637,646,276,111);
                g.setFont(new Font(Font.SERIF,Font.BOLD,40));
                g.setColor(startTextColor);
                g.drawString("Start", 730, 710);

            }
        };
        started = false;
        checkStarted = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (started == true) {
                    startSelectionScreen1();
                }
            }
        });
        checkPlayer1Chosen = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cs1.finished) {
                    player1 = new Player(cs1.getCharacterValue());
                    startSelectionScreen2();
                }
            }
        });
        checkPlayer2Chosen = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cs2.finished) {
                    player2 = new Player(cs2.getCharacterValue());
                    startGame();
                }
            }
        });
        initFrame();
    }

    public void initFrame() {

        welcome.setSize(1550,838);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setTitle("Big Ten Brawl");
        welcome.add(welComp);
        welcome.setVisible(true);
        welcome.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 637 && e.getX() <= 913 && e.getY() >= 646 && e.getY() <= 757) {
                    changeStartColor();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() >= 637 && e.getX() <= 913 && e.getY() >= 646 && e.getY() <= 757) {
                    changeStartColor();
                    welcome.setVisible(false);
                    started = true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        checkStarted.start();

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

    public void startSelectionScreen1() {
        checkStarted.stop();
        checkPlayer1Chosen.start();
        cs1 = new CharacterSelect(1, -1);
        cs1.initFrame();
    }

    public void startSelectionScreen2() {
        checkPlayer1Chosen.stop();
        cs1.close();
        checkPlayer2Chosen.start();
        cs2 = new CharacterSelect(2, player1.getCharacter());
        cs2.initFrame();
    }

    public void startGame() {
        checkPlayer2Chosen.stop();
        cs2.close();
        Game g = new Game(player1,player2);
    }
}
