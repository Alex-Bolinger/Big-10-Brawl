import javax.swing.*;
import java.awt.*;

public class Big10Brawl {
    public static void main(String[] args) {
        Big10Brawl b10B = new Big10Brawl();
        b10B.initFrame();
    }

    private JFrame welcome;

    public Big10Brawl() {
        welcome = new JFrame();
    }

    public void initFrame() {
        welcome.setSize(new Dimension(640,360));
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setTitle("Big10Brawl");
        welcome.add(new JComponent() {
            public void paint(Graphics g) {

            }
        });
        welcome.setVisible(true);
        welcome.repaint();
    }
}
