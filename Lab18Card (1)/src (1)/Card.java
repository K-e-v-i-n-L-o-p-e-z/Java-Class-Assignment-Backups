//Kevin Lopez - Making a card application using Java Awt and Jframe
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JFrame implements ActionListener {
    //creating menu objects
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenuItem = new JMenu("File");
    private JMenu selectionMenuItem = new JMenu("Select");
    private JMenu colorsMenuItem = new JMenu("Colors");
    private JMenu fontMenuItem = new JMenu("Font");
    private JMenuItem file_Exit = new JMenuItem("Exit");
    private JMenuItem select_Home = new JMenuItem("Home");
    private JMenuItem select_Congrats = new JMenuItem("Congratulations Card");
    private JMenuItem select_Birthday = new JMenuItem("Birthday Card");
    private JMenu brightMenu = new JMenu("Bright");
    private JMenuItem bright_yellow = new JMenuItem("Yellow");
    private JMenuItem bright_pink = new JMenuItem("Pink");
    private JMenu darkMenu = new JMenu("Dark");
    private JMenuItem dark_black;
    private JMenuItem dark_gray;
    private JMenuItem white_color = new JMenuItem("white");
    private JMenuItem font_Arial = new JMenuItem("Arial");
    private JMenuItem font_Lucida = new JMenuItem("Lucida Handwriting");
    private JMenuItem font_inkFree = new JMenuItem("Ink Free");
    //main card
    private JPanel panel = new JPanel();
    private JLabel maincardTitle, mainCardDescription;
    private JTextArea mainCardTextArea, mainCardTextArea2, mainCardTextArea3;
    //second panel
    private JPanel panel2 = new JPanel();
    private JLabel maincardTitle2, mainCardDescription2;
    private CardLayout cardLayout = new CardLayout();

    Card() {
        super("Pimp My JFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(cardLayout);
        setJMenuBar(menuBar);

        maincardTitle = new JLabel("Card Designer Application");
        maincardTitle.setHorizontalAlignment(JLabel.HORIZONTAL);
        maincardTitle.setFont(new Font("Arial", Font.BOLD, 14));
        mainCardDescription = new JLabel("Then Get Started By Making Selections From The Menu");
        mainCardDescription.setHorizontalAlignment(JLabel.HORIZONTAL);
        mainCardDescription.setFont(new Font("Arial", Font.BOLD, 14));
        mainCardTextArea = new JTextArea("Please Enter The Recipient's Name");
        mainCardTextArea.selectAll();
        mainCardTextArea.setFont(new Font("Arial", Font.BOLD, 25));
        menuBar.add(fileMenuItem);
        menuBar.add(selectionMenuItem);
        menuBar.add(colorsMenuItem);
        menuBar.add(fontMenuItem);
        fileMenuItem.add(file_Exit);
        selectionMenuItem.add(select_Home);
        selectionMenuItem.add(select_Congrats);
        selectionMenuItem.add(select_Birthday);
        colorsMenuItem.add(brightMenu);
        brightMenu.add(bright_pink);
        brightMenu.add(bright_yellow);
        colorsMenuItem.add(darkMenu);
        dark_black = new JMenuItem("Black");
        darkMenu.add(dark_black);
        dark_gray = new JMenuItem("Gray");
        darkMenu.add(dark_gray);
        colorsMenuItem.add(white_color);
        fontMenuItem.add(font_Arial);
        fontMenuItem.add(font_Lucida);
        fontMenuItem.add(font_inkFree);
        file_Exit.addActionListener(this);
        select_Home.addActionListener(this);
        select_Congrats.addActionListener(this);
        select_Birthday.addActionListener(this);
        white_color.addActionListener(this);
        bright_pink.addActionListener(this);
        bright_yellow.addActionListener(this);
        dark_black.addActionListener(this);
        dark_gray.addActionListener(this);
        font_Arial.addActionListener(this);
        font_inkFree.addActionListener(this);
        font_Lucida.addActionListener(this);

        add(panel, "panel");
        panel.setLayout(new GridLayout(3, 1, 1, 1));
        panel.add(maincardTitle);
        panel.add(mainCardTextArea);
        panel.add(mainCardDescription);
        panel2.setLayout(new GridLayout(2, 1, 1, 1));
        maincardTitle2 = new JLabel(mainCardTextArea.getText());
        panel2.add(maincardTitle2);
        mainCardTextArea2 = new JTextArea("Enter Your message here");
        maincardTitle2.setFont(new Font("Arial", Font.BOLD, 25));
        panel2.add(mainCardTextArea2);
        add(panel2,"panel2");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == file_Exit) {//Exit the program
            System.exit(0);
        } else if (source == select_Home) {//change the layout to home card
            cardLayout.show(getContentPane(), "panel");
        } else if (source == select_Birthday) {//change the layout to home card
            maincardTitle2.setText("Happy Birthday " + mainCardTextArea.getText());
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == select_Congrats) {//change the text to say congratulations
            maincardTitle2.setText("Congratulations " + mainCardTextArea.getText());
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == font_Arial) {//change font to Arial
            maincardTitle2.setFont(new Font("Arial", Font.BOLD, 25));
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == font_inkFree) {//change font to Papyrus
            maincardTitle2.setFont(new Font("Papyrus", Font.BOLD, 25));
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == font_Lucida) {//change font to Lucida
            maincardTitle2.setFont(new Font("Lucida Handwriting",Font.ITALIC,25));
            cardLayout.show(getContentPane(), "panel2");
        } else if(source == white_color) {//change background to white
            panel2.setBackground(Color.WHITE);
            panel.setBackground(Color.WHITE);
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == bright_pink) {//change background to white
            panel2.setBackground(Color.PINK);
            panel.setBackground(Color.PINK);
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == bright_yellow) {//change background to pink
            panel2.setBackground(Color.YELLOW);
            panel.setBackground(Color.YELLOW);
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == dark_black) {//change background to black
            panel2.setBackground(Color.BLACK);
            panel.setBackground(Color.BLACK);
            cardLayout.show(getContentPane(), "panel2");
        } else if (source == dark_gray) {//change background to gray
            panel2.setBackground(Color.GRAY);
            panel.setBackground(Color.GRAY);
            cardLayout.show(getContentPane(), "panel2");
        }
    }
}