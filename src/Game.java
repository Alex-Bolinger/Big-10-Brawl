import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Game {
    private JFrame game;
    private JComponent gComp;
    private Player player1;
    private Player player2;
    private BufferedImage bg;
    private BufferedImage sprite1;
    private BufferedImage sprite2;

    private Timer frameUpdate;

    public Game(Player player1, Player player2) {
        game = new JFrame();
        gComp = new JComponent() {
            public void paint(Graphics g) {
                if (bg == null) {
                    try {
                        bg = ImageIO.read(new File("bin/FOOTBALL_STAGE.png"));
                        sprite1 = ImageIO.read(new File("bin/Characters/" +
                                Character.getCharacterName(player1.getCharacter()) + "/" +
                                Character.getCharacterName(player1.getCharacter()) + "_" +
                                player1.getFacing() +
                                player1.getMoveState() + ".png"));
                        sprite2 = ImageIO.read(new File("bin/Characters/" +
                                Character.getCharacterName(player2.getCharacter()) + "/" +
                                Character.getCharacterName(player2.getCharacter()) + "_" +
                                player2.getFacing() +
                                player2.getMoveState() +".png"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                g.drawImage(bg,0,0,null);
                g.drawImage(sprite1,player1.getLocation().x,player1.getLocation().y,null);
                g.drawImage(sprite2,player2.getLocation().x,player2.getLocation().y,null);
            }
        };
        this.player1 = player1;
        this.player2 = player2;
        player1.setLocation(new Point(100,250));
        player2.setLocation(new Point(1200, 250));
        player1.setFacing("R");
        player2.setFacing("L");
        player1.setMoveState("I");
        player2.setMoveState("I");
        game.setSize(1550,838);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(gComp);
        game.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    if (player1.getLocation().y == 250) {
                        jump(player1);
                    }

                }
                if (e.getKeyChar() == 'a') {
                    player1.setFacing("L");
                }

                if (e.getKeyChar() == 'd') {
                    player1.setFacing("R");
                }

                if (e.getKeyChar() == 'i') {
                    if (player2.getLocation().y == 250) {
                        jump(player2);
                    }
                }

                if (e.getKeyChar() == 'l') {
                    player2.setFacing("R");
                }

                if (e.getKeyChar() == 'j') {
                    player2.setFacing("L");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        game.setVisible(true);
        game.repaint();
        frameUpdate = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.repaint();
                accelerate(player1);
                accelerate(player2);
                changeY(player1);
                changeY(player2);
                updateSprites();
            }
        });
        frameUpdate.start();
    }

    public void updateSprites() {
        try {
            sprite1 = ImageIO.read(new File("bin/Characters/" +
                    Character.getCharacterName(player1.getCharacter()) + "/" +
                    Character.getCharacterName(player1.getCharacter()) + "_" +
                    player1.getFacing() +
                    player1.getMoveState() + ".png"));
            sprite2 = ImageIO.read(new File("bin/Characters/" +
                    Character.getCharacterName(player2.getCharacter()) + "/" +
                    Character.getCharacterName(player2.getCharacter()) + "_" +
                    player2.getFacing() +
                    player2.getMoveState() + ".png"));
        } catch (IOException e) {
            System.out.println("Stack error");
        }
    }

    public void changeX(Player player) {
        player.setLocation(new Point(player.getLocation().x + player.gethVelocity(), player.getLocation().y));
    }

    public void jump(Player player) {
        player.setVelocity(player.getSpeed() / 5);
    }

    public void accelerate(Player player) {
        if (player.getLocation().y > 250 && player.getVelocity() > 0) {
            player.setVelocity(0);
            player.setLocation(new Point(player.getLocation().x, 250));
            System.out.println("set to 0");
        } else {
            player.setVelocity(player.getVelocity() - 1);
        }
    }
    public void changeY(Player player) {
        player.setLocation(new Point(player.getLocation().x, player.getLocation().y - player.getVelocity()));
    }

    public void turnAround(Player player) {

    }
}
