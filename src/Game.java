import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame game;
    private JComponent gComp;
    private Player player1;
    private Player player2;
    private BufferedImage bg;
    private BufferedImage sprite1;
    private BufferedImage sprite2;

    private Timer frameUpdate;

    private boolean oscillating1;
    private int counter1;
    private boolean oscillating2;
    private int counter2;

    private int kCounter;

    private int sCounter;


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
                g.setColor(Color.RED);
                g.fillRect(0,0,775 * player1.getHealth() / Character.getHealth(player1.getCharacter()), 50);
                g.fillRect(1550 - 775 * player2.getHealth() / Character.getHealth(player2.getCharacter()), 0, 775 * player2.getHealth() / Character.getHealth(player2.getCharacter()), 50);
                g.setColor(Color.blue);
                g.fillRect(0,50,775 * player1.getCharge() / Character.getMaxCharge(player1.getCharacter()), 50);
                g.fillRect(1550 - 775 * player2.getCharge() / Character.getMaxCharge(player2.getCharacter()), 50, 775 * player2.getCharge() / Character.getMaxCharge(player2.getCharacter()), 50);
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.SERIF,Font.BOLD,40));
                g.drawString(Integer.toString(player1.getPoints()),100,150);
                g.drawString(Integer.toString(player2.getPoints()),1450,150);
            }
        };
        this.player1 = player1;
        this.player2 = player2;
        player1.setCharge(0);
        player2.setCharge(0);
        player1.setLocation(new Point(100,250));
        player2.setLocation(new Point(1200, 250));
        player1.setFacing("R");
        player2.setFacing("L");
        player1.setMoveState("I");
        player2.setMoveState("I");
        oscillating1 = false;
        counter1 = 0;
        oscillating2 = false;
        counter2 = 0;
        player1.setKicking(false);
        player2.setKicking(false);
        player1.setDoingSpecial(false);
        player2.setDoingSpecial(false);
        kCounter = 0;
        sCounter = 0;
        game.setSize(1550,838);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(gComp);
        game.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    if (player1.getLocation().y == 250) {
                        jump(player1);
                    }

                }
                if (e.getKeyChar() == 'a') {
                    player1.setFacing("L");
                    player1.sethVelocity(player1.getSpeed() * -1 / 4);
                    oscillating1 = true;
                }

                if (e.getKeyChar() == 'd') {
                    player1.setFacing("R");
                    player1.sethVelocity(player1.getSpeed() / 4);
                    oscillating1 = true;
                }

                if (e.getKeyChar() == 'i') {
                    if (player2.getLocation().y == 250) {
                        jump(player2);
                    }
                }

                if (e.getKeyChar() == 'l') {
                    player2.setFacing("R");
                    player2.sethVelocity(player2.getSpeed() / 4);
                    oscillating2 = true;
                }

                if (e.getKeyChar() == 'j') {
                    player2.setFacing("L");
                    player2.sethVelocity(player2.getSpeed() * -1 / 4);
                    oscillating2 = true;
                }

                if (e.getKeyChar() == 'q') {
                    punch(player1, player2);
                } //punch animation player 1

                if (e.getKeyChar() == 'u') {
                    punch(player2, player1);
                } //punch animation player 2

                //need to make kicks slower but more powerful, but I'm too tired rn to do that.
                if (e.getKeyChar() == 'e') {
                    player1.setKicking(true);
                } //kick animation player 1


                if (e.getKeyChar() == 'o') {
                    player2.setKicking(true);
                } //kick animation player 2

                if (e.getKeyChar() == 'r') {
                    player1.setDoingSpecial(true);
                }

                if(e.getKeyChar() == 'p') {
                    player2.setDoingSpecial(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'a') {
                    player1.sethVelocity(0);
                    oscillating1 = false;
                    player1.setMoveState("I");
                    counter1 = 0;
                }

                if (e.getKeyChar() == 'd') {
                    player1.sethVelocity(0);
                    oscillating1 = false;
                    player1.setMoveState("I");
                    counter1 = 0;
                }
                if (e.getKeyChar() == 'l') {
                    player2.sethVelocity(0);
                    oscillating2 = false;
                    player2.setMoveState("I");
                    counter2 = 0;
                }

                if (e.getKeyChar() == 'j') {
                    player2.sethVelocity(0);
                    oscillating2 = false;
                    player2.setMoveState("I");
                    counter2 = 0;
                }

                if (e.getKeyChar() == 'q') {
                    player1.setMoveState("I");
                }

                if (e.getKeyChar() == 'u') {
                    player2.setMoveState("I");
                }

                if (e.getKeyChar() == 'e') {
                    player1.setMoveState("I");
                }

                if (e.getKeyChar() == 'o') {
                    player2.setMoveState("I");
                }
            }
        });
        game.setVisible(true);
        game.repaint();
        frameUpdate = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.repaint();
                checkForWin();
                accelerate(player1);
                accelerate(player2);
                changeY(player1);
                changeY(player2);
                changeX(player1);
                changeX(player2);
                oscillate1();
                oscillate2();
                kick(player1,player2);
                kick(player2,player1);
                special(player1, player2);
                special(player2,player1);
                if (player1.getCharge() < Character.getMaxCharge(player1.getCharacter())) {
                    player1.setCharge(player1.getCharge() + 2);
                }
                if (player2.getCharge() < Character.getMaxCharge(player2.getCharacter())) {
                    player2.setCharge(player2.getCharge() + 2);
                }
                updateSprites();
            }
        });
        frameUpdate.start();
    }

    public void checkForWin() {
        if (player1.getHealth() <= 0) {
            player2.setPoints(player2.getPoints() + 1);
            game.setVisible(false);
            if (player2.getPoints() == 2) {
                System.exit(0);
            } else {
                player1.setHealth(Character.getHealth(player1.getCharacter()));
                player2.setHealth(Character.getHealth(player2.getCharacter()));
                Game g = new Game(player1, player2);
            }
        }
        if (player2.getHealth() <= 0) {
            player1.setPoints(player1.getPoints() + 1);
            game.setVisible(false);
            if (player1.getPoints() == 2) {
                System.exit(0);
            } else {
                player1.setHealth(Character.getHealth(player1.getCharacter()));
                player2.setHealth(Character.getHealth(player2.getCharacter()));
                Game g = new Game(player1, player2);
            }
        }
    }

    public void kick(Player player, Player otherPlayer) {
        if (player.isKicking()) {
            kCounter++;
            if (kCounter == 5) {
                player.setKicking(false);
                kCounter = 0;
                if (player.getCharge() >= Character.getMaxCharge(player.getCharacter()) / 2) {
                    player.setCharge(player.getCharge() - Character.getMaxCharge(player.getCharacter()) / 2);
                    if (player.getFacing().equals("L")) {
                        if (player.getLocation().x < otherPlayer.getLocation().x + 256 &&
                                player.getLocation().x > otherPlayer.getLocation().x &&
                                player.getLocation().y >= otherPlayer.getLocation().y &&
                                player.getLocation().y < otherPlayer.getLocation().y + 512) {
                            otherPlayer.setHealth(otherPlayer.getHealth() - Character.getKickDamage(player.getCharacter()));
                        }
                    }
                    if (player.getFacing().equals("R"))
                    {
                        if (player.getLocation().x + 256 > otherPlayer.getLocation().x &&
                                player.getLocation().x < otherPlayer.getLocation().x &&
                                player.getLocation().y >= otherPlayer.getLocation().y &&
                                player.getLocation().y < otherPlayer.getLocation().y + 512) {
                            otherPlayer.setHealth(otherPlayer.getHealth() - 5);
                        }
                    }
                    player.setMoveState("K");
                }
            }
        } else {
            player.setKicking(false);
        }
    }

    public void punch(Player player, Player otherPlayer) {
        if (player.getCharge() >= Character.getMaxCharge(player.getCharacter()) / 4) {
            player.setCharge(player.getCharge() - Character.getMaxCharge(player.getCharacter()) / 4);
            if (player.getFacing().equals("L")) {
                if (player.getLocation().x < otherPlayer.getLocation().x + 256 &&
                        player.getLocation().x > otherPlayer.getLocation().x &&
                        player.getLocation().y >= otherPlayer.getLocation().y &&
                        player.getLocation().y < otherPlayer.getLocation().y + 512) {
                    otherPlayer.setHealth(otherPlayer.getHealth() - Character.getPunchDamage(player.getCharacter()));
                }
            }
            if (player.getFacing().equals("R"))
            {
                if (player.getLocation().x + 256 > otherPlayer.getLocation().x &&
                        player.getLocation().x < otherPlayer.getLocation().x &&
                        player.getLocation().y >= otherPlayer.getLocation().y &&
                        player.getLocation().y < otherPlayer.getLocation().y + 512) {
                    otherPlayer.setHealth(otherPlayer.getHealth() - Character.getPunchDamage(player.getCharacter()));
                }
            }
            player.setMoveState("P");
        }
    }

    public void special(Player player, Player otherPlayer) {
        if (player.getCharge() == Character.getMaxCharge(player.getCharacter())) {
            if (player.isDoingSpecial()) {
                sCounter++;
                System.out.println(sCounter);
                if (sCounter == 10) {
                    player.setCharge(0);
                    player.setDoingSpecial(false);
                    sCounter = 0;
                    if (player.getFacing().equals("L")) {
                        if (player.getLocation().x > otherPlayer.getLocation().x) {
                            otherPlayer.setHealth(otherPlayer.getHealth() - Character.getSpecialDamage(player.getCharacter()));
                            System.out.println("L");
                        }
                    }
                    if (player.getFacing().equals("R")) {
                        if (player.getLocation().x < otherPlayer.getLocation().x) {
                            otherPlayer.setHealth(otherPlayer.getHealth() - Character.getSpecialDamage(player.getCharacter()));
                            System.out.println("R");
                        }
                    }
                    player.setMoveState("SP");
                }
            }
        } else {
            player.setDoingSpecial(false);
        }
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

    public void oscillate1() {
       if (oscillating1) {
           counter1++;
           if (counter1 == 5) {
               if (player1.getMoveState().equals("I")) {
                   player1.setMoveState("M");
               } else {
                   player1.setMoveState("I");
               }
               counter1 = 0;
           }
       }
    }

    public void oscillate2() {
        if (oscillating2) {
            counter2++;
            if (counter2 == 5) {
                if (player2.getMoveState().equals("I")) {
                    player2.setMoveState("M");
                } else {
                    player2.setMoveState("I");
                }
                counter2 = 0;
            }
        }
    }

    public void changeX(Player player) {
        player.setLocation(new Point(player.getLocation().x + player.gethVelocity(), player.getLocation().y));
    }

    public void jump(Player player) {
        player.setVelocity(player.getSpeed() / 4);
    }

    public void accelerate(Player player) {
        if (player.getLocation().y > 250 && player.getVelocity() > 0) {
            player.setVelocity(0);
            player.setLocation(new Point(player.getLocation().x, 250));
            System.out.println("set to 0");
        } else {
            player.setVelocity(player.getVelocity() - 2);
        }
    }
    public void changeY(Player player) {
        player.setLocation(new Point(player.getLocation().x, player.getLocation().y - player.getVelocity()));
    }
}
