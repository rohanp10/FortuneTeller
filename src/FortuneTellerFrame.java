import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton readFortune;
    JButton quit;

    ArrayList<String> fortunes = new ArrayList<String>();

    int fortuneIndex = -1;

    Random rnd = new Random();


    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());

        createTopPnl();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePnl();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPnl();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

    }

    private void createTopPnl()
    {
        topPnl = new JPanel();
        icon = new ImageIcon("src/fortuneTeller.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);

        titleLbl.setFont(new Font("Roboto", Font.PLAIN, 36));

        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.setBackground(new Color(198,226,255));

        topPnl.add(titleLbl);
    }

    private void createMiddlePnl()
    {
        middlePnl = new JPanel();
        displayTA = new JTextArea(10, 40);

        displayTA.setFont(new Font("Verdana", Font.PLAIN, 20));

        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);

        middlePnl.setBackground(new Color(198,226,255));

    }

    private void createBottomPnl()
    {

        fortunes.add("You will meet a new friend in the next week!");
        fortunes.add("A large sum of money will be granted to you!");
        fortunes.add("The weather tomorrow will alter some of your plans!");
        fortunes.add("A mysterious note will soon be in your possession!");
        fortunes.add("An unexpected pet will be added into your family!");
        fortunes.add("A call from an unknown number will reveal a shocking secret!");
        fortunes.add("An invitation to a party will change the course of your life!");
        fortunes.add("While cleaning your room, you will find a forgotten souvenir!");
        fortunes.add("Tomorrow's lunch will be the most delicious meal you have ever had!");
        fortunes.add("A sudden viral post will make you a celebrity overnight!");
        fortunes.add("Your jokes tomorrow will make everyone around you laugh!");
        fortunes.add("You will stumble upon a valuable ancient artifact this week!");


        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        readFortune = new JButton("Read My Fortune!");
        readFortune.addActionListener((ActionEvent ae) ->
        {
            int index = rnd.nextInt(12);
            while (index == fortuneIndex) {
                index = rnd.nextInt(12);
            }

            fortuneIndex = index;

            String fortune = fortunes.get(index);

            displayTA.append(fortune + "\n");
        });

        quit = new JButton("Quit");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));

        readFortune.setPreferredSize(new Dimension(40, 40));
        quit.setPreferredSize(new Dimension(40, 40));

        readFortune.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        quit.setFont(new Font("Sans Serif", Font.PLAIN, 15));

        bottomPnl.add(readFortune);
        bottomPnl.add(quit);

        bottomPnl.setBackground(new Color(198,226,255));

    }
}
