import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame game;
    private JComponent gComp;
    private Player player1;
    private Player player2;
    private BufferedImage bg;

    public Game(Player player1, Player player2) {
        game = new JFrame();
        gComp = new JComponent() {
            public void paint(Graphics g) {
                if (bg == null) {
                }
            }
        };
        this.player1 = player1;
        player1 =
        this.player2 = player2;
    }
}
