import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by coreyjones on 10/2/17.
 */
public class GameWindow {

    public static void GameWindow() {
        JFrame main = new JFrame("Eventyr");
        main.setLayout(new GridBagLayout());
        main.setSize(854, 480);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();
        JButton button8 = new JButton();

        main.setVisible(true);
    }

    public static void main(String args[]) {

        GameWindow();
    }
}

