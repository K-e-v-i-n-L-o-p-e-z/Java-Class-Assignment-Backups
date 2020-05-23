//Kevin Lopez Lab 15 -- creating a card program, it shows you a card then moves to another card
//it uses JFram and ActionListener
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MadLib extends JFrame implements ActionListener {

    //Making the buttons in the program
    JButton nextButton = new JButton("Next");
    JButton previousButton = new JButton("Previous");
    JButton exitButton = new JButton("Exit");
    JPanel northPanel = new JPanel();
    JPanel northPanel2 = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel cardPanel1 = new JPanel();
    JPanel cardPanel2 = new JPanel();
    CardLayout cardLayout = new CardLayout();
    JLabel titleField, titleField2, line1, line2, line3, line4;
    JTextField field1, field2, field3, field4;
    JTextArea textArea = new JTextArea();


    public MadLib() {
        super("CardLayout");
        setSize(450, 200);
        setLayout(cardLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        previousButton.addActionListener(this);
        exitButton.addActionListener(this);
        nextButton.addActionListener(this);
        titleField = new JLabel("Welcome To Mad Libs");
        titleField2 = new JLabel("Welcome To Mad Libs");
        titleField2.setFont(new Font("Arial", 1, 14));
        titleField.setFont(new Font("Arial", 1, 14));
        line1 = new JLabel("Please Enter Your Name");
        line2 = new JLabel("Please Enter A Verb ending with ''in'' ");
        line3 = new JLabel("Please Enter A Plural Noun");
        line4 = new JLabel("Please Enter An Adjective");
        field1 = new JTextField(8);
        field2 = new JTextField(8);
        field3 = new JTextField(8);
        field4 = new JTextField(8);

        cardPanel1.setLayout(new BorderLayout());

        northPanel.add(titleField);

        centerPanel.setLayout(new FlowLayout());

        centerPanel.add(line1);
        centerPanel.add(field1);
        centerPanel.add(line2);
        centerPanel.add(field2);
        centerPanel.add(line3);
        centerPanel.add(field3);
        centerPanel.add(line4);
        centerPanel.add(field4);
        westPanel.add(previousButton);
        eastPanel.add(nextButton);

        cardPanel1.add(centerPanel, BorderLayout.CENTER);
        cardPanel1.add(nextButton, BorderLayout.EAST);
        cardPanel1.add(northPanel, BorderLayout.NORTH);
        add(cardPanel1, "cardpanel");


        //creating the second card layout
        cardPanel2.setLayout(new BorderLayout());
        northPanel2.add(titleField2);
        cardPanel2.add(exitButton, BorderLayout.EAST);
        cardPanel2.add(previousButton, BorderLayout.WEST);
        cardPanel2.add(textArea, BorderLayout.CENTER);
        cardPanel2.add(northPanel2, BorderLayout.NORTH);
        add(cardPanel2, "cardpanel2");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source == nextButton) {
            //setting the text using the method i made to help me choose which text to use
            textArea.setText(changeString(field1.getText(), field2.getText(), field3.getText(), field4.getText()));
            textArea.setFont(new Font("Arial", 1, 15));
            cardLayout.show(getContentPane(), "cardpanel2");//switch to card two
        } else if (source == previousButton) {
            cardLayout.show(getContentPane(), "cardpanel");//switch to card one
        } else if (source == exitButton) {
            super.dispose(); //close the program
        }
    }

    //I used a method named changeString to help me choose 1 of 2 strings to display
    private String changeString(String na, String ver, String no, String adj) {
        String name = na;
        String adjective = adj;
        String noun = no;
        String verb = ver;

        String text = "Hi there, all you " + adjective + " little boys and girls!\n" +
                "This is your old TV buddy, " + na + "!\n" +
                "With another " + adjective + "-hour program of\n" + verb + " " + noun + " for all of you";

        String text2 = "Driving a car can be fun...\n" +
                "If you follow " + name + "'s Boring advice:\n" +
                "Before " + verb + ", always stick your " + noun + "\n" +
                "out of the window";
        //returns the either the first one or second one
        int rand = (int) (Math.random() * 2);
        if (rand == 1) {
            return text;
        } else {
            return text2;
        }
    }
}
