import javafx.beans.binding.ObjectBinding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuFrame extends JFrame implements ActionListener {

    private JMenuBar mainBar = new JMenuBar();
    private JMenu menu1 = new JMenu("File");//what you want that menu to say
    private JMenu menu2 = new JMenu("Colors");
    private JMenuItem exitButton = new JMenuItem("Exit");
    private JMenuItem yellow = new JMenuItem("Yellow");





    public JMenuFrame(){
        super("Menus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(new FlowLayout());
        setJMenuBar(mainBar);
        mainBar.add(menu1);
        mainBar.add(menu2);
        menu1.add(exitButton);
        menu2.add(yellow);

        exitButton.addActionListener(this);
        yellow.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        //content pane object for setting the background color
        Container container = getContentPane();
        if(source == exitButton){
            //exits the program
            System.exit(0);
        }
        else if(source == yellow){

            container.setBackground(Color.YELLOW);
        }
    }
}
