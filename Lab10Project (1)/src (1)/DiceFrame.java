//Kevin Lopez lab 14 creating a GAMBLING dice game that checks for funds, adds more to the funds, and takes away funds
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DiceFrame extends JFrame implements ActionListener, ItemListener {

    private int funds;
    int moneyToBet = 0;
    JLabel title, centerText, westText, southLabe1, southLabel2;
    JButton eastButton, southButton, button1, button2, button3;
    JPanel centerPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JTextField centerTextField, westTextField;
    String[] boolArray = {"Quick Bet", "$100", "$350", "$500"};
    JComboBox comboBox = new JComboBox(boolArray);
    int startingMoney = 1000;

    public DiceFrame() {
        super("Casino Simulator");
        setSize(400, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        funds = 1000;

        //WEST SIDE
        westPanel.setLayout(new GridLayout(2, 1, 5, 5));
        westText = new JLabel("Cash Available");
        westTextField = new JTextField("$" + startingMoney);
        westTextField.setEditable(false);
        westTextField.setFont(new Font("Arial", 1, 15));
        add(westPanel, BorderLayout.WEST);
        westPanel.add(westText);
        westPanel.add(westTextField);

        //NORTH SIDE
        title = new JLabel("Welcome To The High Rollers Game");
        title.setFont(new Font("Arial", 1, 16));
        add(title, BorderLayout.NORTH);

        //CENTER SECTION DECLARATIONS
        centerText = new JLabel("Place your Bet");
        centerTextField = new JTextField(10);
        button1 = new JButton("D1");
        button2 = new JButton("D2");
        button3 = new JButton("D3");
        centerTextField.setFont(new Font("Arial", 1, 14));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(button1);
        centerPanel.add(button2);
        centerPanel.add(button3);
        centerPanel.add(centerText);
        centerPanel.add(centerTextField);

        //EAST SIDE
        eastButton = new JButton("Cash Out");
        eastPanel.setLayout(new GridLayout(2, 1, 5, 5));
        add(eastPanel, BorderLayout.EAST);
        eastPanel.add(eastButton);
        eastPanel.add(comboBox);
        comboBox.addItemListener(this);

        //SOUTH SIDE
        southLabe1 = new JLabel();
        southLabel2 = new JLabel();
        southButton = new JButton("Roll Dice");
        southPanel.setLayout(new GridLayout(1,3));
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(southLabe1);
        southPanel.add(southButton);
        southPanel.add(southLabel2);
        southButton.addActionListener(this);
        eastButton.addActionListener(this);
    }

    public void rollDice(int cash) {
        //roll the die
        if(cash <= funds){
            int random1 = (int) (Math.random() * 6) + 1;
            int random2 = (int) (Math.random() * 6) + 1;
            int random3 = (int) (Math.random() * 6) + 1;
            button1.setText(String.valueOf(random1));
            button2.setText(String.valueOf(random2));
            button3.setText(String.valueOf(random3));
            //checking to see if two are the same
            if (random1 == random2 || random1 == random3 || random2 == random3) {
                funds += cash*2;
                westTextField.setText("$" + funds);
            }
            // checking to see if all 3 of them are the same
            else if (random1 == random2 && random2 == random3) {
                funds *= cash*3; //we're increasing the funds because they won
                westTextField.setText("$" + funds);
            }
            else{
                //remove some of the funds
                funds -= cash;
                southLabel2.setText("Better luck next time!");//because he lost
                southLabe1.setFont(new Font("Arial", Font.BOLD, 6));//change my
                westTextField.setText("$" + funds);
            }
        }
        else{
            //dont do anything, they dont have enough funds to play
            southLabe1.setText("Insufficient Funds");
            southLabe1.setFont(new Font("Arial", Font.BOLD, 10));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source == southButton){
            int amount = Integer.parseInt(centerTextField.getText());
            rollDice(amount);
        }
        else if(source == eastButton){
            super.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Object source = itemEvent.getSource();
        int select = itemEvent.getStateChange();
        //in these if statement blocks we check to see which selection they made
        if(select == ItemEvent.SELECTED){
            int positionOfSelection = comboBox.getSelectedIndex();
            if(positionOfSelection == 1){
                moneyToBet = 100;
                centerTextField.setText("100");
            }else if(positionOfSelection == 2){
                moneyToBet = 350;
                centerTextField.setText("350");
            }
            else if(positionOfSelection == 3){
                moneyToBet = 500;
                centerTextField.setText("500");
            }
        }
    }
}