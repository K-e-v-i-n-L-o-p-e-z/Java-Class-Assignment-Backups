import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCardLayout extends JFrame implements ActionListener {
    JButton next = new JButton("Next");
    JButton next2 = new JButton("Exit");

    JPanel buttonPanel = new JPanel();
    JPanel buttonPanel2 = new JPanel();

    //think of this as a deck of cards
    CardLayout cardLayout = new CardLayout();

    public JCardLayout(){
        super("CardLayout");
        setLayout(cardLayout); //new CardLayout()
        setSize(400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //DOES IT MATTER IF I DID JFrame.EXIT_ON_CLOSE

        next.addActionListener(this);
        next2.addActionListener(this);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(new JButton("1"));
        buttonPanel.add(new JButton("2"));
        buttonPanel.add(new JButton("3"));
        buttonPanel.add(next);

        //The string parm names the component for the deck
        add(buttonPanel, "Panel 1");


        buttonPanel2.setLayout(new FlowLayout());
        buttonPanel2.add(new JButton("1"));
        buttonPanel2.add(new JButton("2"));
        buttonPanel2.add(new JButton("3"));
        buttonPanel2.add(next2);

        //The string parm names the component for the deck
        add(buttonPanel2, "Panel 2");


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if(source == next){
            cardLayout.show(getContentPane(),"Panel 2");
            //go to the next card
            //flip to the next card in the deck
            //cardLayout.next(getContentPane()); //kinda confused.. not gonna lie

        }else if(source == next2){
            cardLayout.show(getContentPane(),"Panel 1");

            //super.dispose();
        }

    }
}
