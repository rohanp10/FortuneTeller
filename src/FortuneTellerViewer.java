import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer {

    public static void main(String[] args) {

        JFrame frame = new FortuneTellerFrame();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        frame.setSize(screenWidth * 3/4, screenHeight / 2);
        frame.setLocationRelativeTo(null);;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
