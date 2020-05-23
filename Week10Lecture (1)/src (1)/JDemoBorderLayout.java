
import javax.swing.*;
import java.awt.*;


public class JDemoBorderLayout extends JFrame{
    JButton northButton = new JButton("North Button");
    JButton southButton = new JButton("South Button");
    JButton eastButton = new JButton("East Button");
    JButton westButton = new JButton("West Button");
    JButton centerButton = new JButton("Center Button");
    //container (similar to the content pane)
    JPanel buttonPanel = new JPanel();




    public JDemoBorderLayout(){
        super("Layouts");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(northButton, BorderLayout.NORTH);
        add(southButton, BorderLayout.SOUTH);
        add(eastButton, BorderLayout.EAST);
        add(westButton, BorderLayout.WEST);
        add(centerButton, BorderLayout.CENTER);

                                            //rows, columns, button padding, bp
        buttonPanel.setLayout(new GridLayout(2,3,5,5));
        add(buttonPanel, BorderLayout.CENTER);

        //creating a bunch of temporary buttons
        buttonPanel.add(new JButton("1"));
        buttonPanel.add(new JButton("2"));
        buttonPanel.add(new JButton("3"));
        buttonPanel.add(new JButton("4"));
        buttonPanel.add(new JButton("5"));
        buttonPanel.add(new JButton("6"));

        //super.dispose() calls the super class's deconstructor
        //itll close the JFrame and end the program

        //textFieldObject.setEditable(false);
    }


}
