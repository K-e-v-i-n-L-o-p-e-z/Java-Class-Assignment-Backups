//Kevin Lopez Lab 16 -- Making a checkerboard with Swing, and a kitty
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkerboard extends JFrame implements ActionListener {
    private final int ROWS = 8;
    private final int COLS = 8;
    private String kitty = "=^.^=";
    private JLabel[][] labelArray = new JLabel[ROWS][COLS];
    private Color tempColor;
    private JButton leftButton = new JButton("LEFT");
    private JButton rightButton = new JButton("RIGHT");
    private JButton upButton = new JButton("UP");
    private JButton downButton = new JButton("DOWN");

    Checkerboard() {
        super("Checkers");
        int size = 600;
        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Chose border layout to get the center and N,S,E,W sections
        JPanel fullPanel = new JPanel(new BorderLayout());
        add(fullPanel);
        fullPanel.add(upButton, BorderLayout.NORTH);
        fullPanel.add(downButton, BorderLayout.SOUTH);
        fullPanel.add(leftButton, BorderLayout.WEST);
        fullPanel.add(rightButton, BorderLayout.EAST);
        //this pane will contain the grid full of panels
        JPanel pane = new JPanel(new GridLayout(ROWS, COLS, 2, 2));//this will allow us to make the board
        fullPanel.add(pane, BorderLayout.CENTER);//putting it in the center

        for (int x = 0; x < 8; ++x) {
            for(int c = 0; c < 8; ++c){
                //array of 64 Jpanels
                JPanel[][] panelArray = new JPanel[ROWS][COLS];
                panelArray[x][c] = new JPanel();//init individual panels
                labelArray[x][c] = new JLabel();//we need this to have each panel have a label
                panelArray[x][c].add(labelArray[x][c]);
                pane.add(panelArray[x][c]); // add the panel to the grid
                if((x+c) % 2 == 0){ // I used this because ut checks to see if the location is even
                    panelArray[x][c].setBackground(Color.WHITE);
                }else{
                    panelArray[x][c].setBackground(Color.BLUE);
                }
            }
        }
        downButton.addActionListener(this);
        upButton.addActionListener(this);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        labelArray[4][4].setText(kitty);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        int rowPos = 0, columnPos = 0;
        //Finds where the kitty is on the board
        for (int row = 0; row < 8; ++row) {
            for(int column = 0; column < 8; ++column){
                if (labelArray[row][column].getText().equals(kitty)){
                    rowPos = row;
                    columnPos = column;
                    break;
                }
            }
        }
        //for the buttons, it only moves the kitty if it doesn't go beyond the board dimensions
        if(source == downButton){
            if((rowPos+1) < 8){//doesn't go past seven
               labelArray[rowPos][columnPos].setText("");
               labelArray[rowPos+1][columnPos].setText(kitty);
            }
        }
        else if(source == upButton){
            if((rowPos-1) > -1){//doesn't go past zero
                labelArray[rowPos][columnPos].setText("");
                labelArray[rowPos-1][columnPos].setText(kitty);
            }
        }
        else if(source == leftButton){
            if((columnPos-1) > -1){//doesn't go past zero
                labelArray[rowPos][columnPos].setText("");
                labelArray[rowPos][columnPos-1].setText(kitty);
            }
        }
        else if(source == rightButton){
            if((columnPos+1) < 8){//doesn't go past seven
                labelArray[rowPos][columnPos].setText("");
                labelArray[rowPos][columnPos+1].setText(kitty);
            }
        }
    }
}
