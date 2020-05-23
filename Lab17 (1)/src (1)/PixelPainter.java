//Kevin Lopez Lab 17 Creating a drawing game using JFrame and KeyListener
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PixelPainter extends JFrame implements KeyListener {
    private final int ROWS = 16;
    private final int COLS = 16;
    private JPanel[][] panelArray = new JPanel[ROWS][COLS];
    private int currentx, currenty;
    private Color[][] colors = new Color[ROWS][COLS];


    PixelPainter(){
        super("Pixel Painter");
        int size = 600;
        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Chose border layout to get the center and N,S,E,W sections
        JPanel fullPanel = new JPanel(new BorderLayout());
        add(fullPanel);
        JPanel pane = new JPanel(new GridLayout(ROWS, COLS, 2, 2));//this will allow us to make the board
        fullPanel.add(pane, BorderLayout.CENTER);//putting it in the center
        for (int x = 0; x < ROWS; ++x){
            for (int c = 0; c < COLS; ++c) {
                //array of 64 Jpanels
                panelArray[x][c] = new JPanel();//init individual panels
                panelArray[x][c].setBackground(Color.WHITE);//default background color
                colors[x][c] = Color.WHITE;//default color is white
                pane.add(panelArray[x][c]); // add the panel to the grid
            }
        }
        panelArray[0][0].setBackground(Color.YELLOW);
        currentx = currenty = 0; //setting the current location
        addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        //if the user pressed the down key
        if(keyCode == KeyEvent.VK_DOWN){
            System.out.println("DOWN BUTTON PRESSED");
            if((currentx+1) < ROWS){
                panelArray[currentx+1][currenty].setBackground(Color.YELLOW);//move
                currentx++;//update
                //setting the previous color to the color of the array's index
                panelArray[currentx-1][currenty].setBackground(colors[currentx-1][currenty]);
            }
        }
        //if the user pressed the up key
        else if(keyCode == KeyEvent.VK_UP){
            if((currentx-1) > -1){//doesn't go past zero
                panelArray[currentx-1][currenty].setBackground(Color.YELLOW);//move
                currentx--;//update
                //setting the previous color to the color of the array's index
                panelArray[currentx+1][currenty].setBackground(colors[currentx+1][currenty]);
            }
        }
        //if the user pressed the left key
        else if(keyCode == KeyEvent.VK_LEFT){
            if((currenty-1) > -1){//doesn't go past zero
                panelArray[currentx][currenty-1].setBackground(Color.YELLOW);//move
                currenty--;//update
                //setting the previous color to the color of the array's index
                panelArray[currentx][currenty+1].setBackground(colors[currentx][currenty+1]);
            }
        }
        //if the user pressed the right key
        else if(keyCode == KeyEvent.VK_RIGHT){
            if((currenty+1) < COLS){//doesn't go past 16
                panelArray[currentx][currenty+1].setBackground(Color.YELLOW);//move
                currenty++;//update
                //setting the previous color to the color of the array's index
                panelArray[currentx][currenty-1].setBackground(colors[currentx][currenty-1]);
            }
        }
        //if they press the space button
        else if(keyCode == KeyEvent.VK_SPACE){
            //if it is currently white, make it black
            if(colors[currentx][currenty] == Color.white){
                colors[currentx][currenty] = Color.black;
            }
            //if it is currently black, make it white
            else if(colors[currentx][currenty] == Color.black){
                colors[currentx][currenty] = Color.white;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
