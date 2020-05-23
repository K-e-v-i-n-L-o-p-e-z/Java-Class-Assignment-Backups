//Kevin Lopez Lab 19 -- Making a making the basic parts of Plants Vs Zombies, using JFrame and KeyListener
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

public class Checkerboard extends JFrame implements KeyListener {
    private int currentx, currenty, arrayIndex = 0, pressCount = 0, ROWS = 8, COLS = 8;
    private ImageIcon image4 = new ImageIcon("C://Users//krozz//Desktop//zombie.png"); //yup that's my username
    private Image transformed4 = image4.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
    private JLabel[][] labelArray = new JLabel[ROWS][COLS];
    private JLabel imageLabel = new JLabel();
    private JLabel[][] phantomArray = new JLabel[ROWS][COLS];
    private Image[] imageArray = new Image[3];

    Checkerboard() {
        super("Plants Vs Zombies");
        int size = 600;
        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Chose border layout to get the center and N,S,E,W sections
        JPanel fullPanel = new JPanel(new BorderLayout());
        ImageIcon image1 = new ImageIcon("C://Users//krozz//Desktop//peaShooter.png");
        Image transformed = image1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(transformed));
        imageArray[0] = transformed;

        ImageIcon image2 = new ImageIcon("C://Users//krozz//Desktop//rock.png");
        Image transformed2 = image2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageArray[1] = transformed2;

        ImageIcon image3 = new ImageIcon("C://Users//krozz//Desktop//sunflower.png");
        Image transformed3 = image3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageArray[2] = transformed3;

        JPanel pane = new JPanel(new GridLayout(ROWS, COLS, 2, 2));//this will allow us to make the board
        add(fullPanel);

        fullPanel.add(pane, BorderLayout.CENTER);//putting it in the center
        //color the board in 2 different colors
        for (int x = 0; x < 8; ++x) {
            for(int c = 0; c < 8; ++c){
                //array of 64 Jpanels
                JPanel[][] panelArray = new JPanel[ROWS][COLS];
                panelArray[x][c] = new JPanel();//init individual panels
                labelArray[x][c] = new JLabel();//we need this to have each panel have a label
                phantomArray[x][c] = new JLabel();
                panelArray[x][c].add(labelArray[x][c]);
                pane.add(panelArray[x][c]); // add the panel to the grid
                if((x) % 2 == 0){//checks to see if the row is even or odd
                    panelArray[x][c].setBackground(Color.GREEN);
                }else{
                    panelArray[x][c].setBackground(Color.GREEN.darker());
                }
            }
        }
        labelArray[4][4].setIcon(new ImageIcon(transformed));
        currentx = currenty = 4; //our starting position
        addKeyListener(this); //adding keylistener in order to know which buttons are pressed
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        //if the user pressed the down key
        if(keyCode == KeyEvent.VK_DOWN){
            if((currentx+1) < ROWS){
                labelArray[currentx+1][currenty].setIcon(new ImageIcon(imageArray[arrayIndex])); //change the next index
                currentx++;//update
                labelArray[currentx-1][currenty].setIcon(phantomArray[currentx-1][currenty].getIcon()); //change the old index
            }
        }
        //if the user pressed the up key
        else if(keyCode == KeyEvent.VK_UP){
            if((currentx-1) > -1){//doesn't go past zero
                labelArray[currentx-1][currenty].setIcon(new ImageIcon(imageArray[arrayIndex])); //change the next index
                currentx--;//update
                labelArray[currentx+1][currenty].setIcon(phantomArray[currentx+1][currenty].getIcon()); //change the old index
            }
        }
        //if the user pressed the left key
        else if(keyCode == KeyEvent.VK_LEFT){
            if((currenty-1) > -1){//doesn't go past zero
                labelArray[currentx][currenty-1].setIcon(new ImageIcon(imageArray[arrayIndex])); //change the next index
                currenty--;//update
                labelArray[currentx][currenty+1].setIcon(phantomArray[currentx][currenty+1].getIcon()); //change the old index
            }
        }
        //if the user pressed the right key
        else if(keyCode == KeyEvent.VK_RIGHT){
            if((currenty+1) < COLS){
                labelArray[currentx][currenty+1].setIcon(new ImageIcon(imageArray[arrayIndex])); //change the next index
                currenty++;//update
                labelArray[currentx][currenty-1].setIcon(phantomArray[currentx][currenty-1].getIcon()); //change the old index
            }
        }
        //if they press the space button
        else if(keyCode == KeyEvent.VK_SPACE){
            pressCount++;
            if(arrayIndex < 2){ //if the array index is less than one
                labelArray[currentx][currenty].setIcon(new ImageIcon(imageArray[arrayIndex +1])); //changing the image
                phantomArray[currentx][currenty].setIcon(new ImageIcon(imageArray[arrayIndex +1])); //updating the phantom array
            }arrayIndex++;
             if(arrayIndex > 2){ //If it's more than one, reset the count
                arrayIndex = 0;
                labelArray[currentx][currenty].setIcon(new ImageIcon(imageArray[0])); //changing the image
                phantomArray[currentx][currenty].setIcon(new ImageIcon(imageArray[0])); //updating the phantom array
            }
            if(pressCount % 4 == 0){
                //choose either the number 6 or the number 7 for a column #
                int y = ThreadLocalRandom.current().nextInt(6,8);
                //choose a number between 0 and 7 for the row #
                int x = ThreadLocalRandom.current().nextInt(0,8);
                labelArray[x][y].setIcon(new ImageIcon(transformed4));//adding a zombie
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent keyEvent){}
}