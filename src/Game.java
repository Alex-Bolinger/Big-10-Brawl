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
    private boolean p1isLeft;
    private boolean p2isRight;

    public Game(Player player1, Player player2) {
        game = new JFrame();
        gComp = new JComponent() {
            public void paint(Graphics g) {
                if (bg == null) {
                    try {
                        bg = ImageIO.read(new File("bin/FOOTBALL_STAGE.png"));
                        sprite1 = ImageIO.read(new File("bin/Characters/"));
                    } catch (IOException e) {
                        System.out.println("Stack Error");
                    }
                }
                g.drawImage(bg,0,0,null);
            }
        };
        this.player1 = player1;
        this.player2 = player2;
        game.setSize(1550,838);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(gComp);
        game.setVisible(true);
    }
}
