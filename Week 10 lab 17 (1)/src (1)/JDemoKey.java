import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JDemoKey extends JFrame implements KeyListener {
    private JLabel prompt = new JLabel("Type keys below");
    private JLabel outputLabel = new JLabel();
    private JTextField textField = new JTextField(10);


    JDemoKey(){
        super("Keyboard Keys");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(new BorderLayout());


        add(prompt, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);
        add(outputLabel, BorderLayout.SOUTH);



        //To listen to arrow keys
        addKeyListener(this); //Listens to the content frame
        textField.addKeyListener(this);




    }


    //Notes: KeyTyped will only execute when a char is typed
    //apparently only works with lowercase keys
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar(); //to get the key that was pressed
        outputLabel.setText("Last key typed: " + c);

    }
    //These methods activate when action keys are pressed
    //Uses virtual keycodes abbreviated as (VK)
    //For example: capital A, you generate shift and an 'a'
    // alt shift arrow keys
    //VK_SHIFT, VK_ALT,  VK_ENTER
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode == KeyEvent.VK_UP){
            textField.setText("You pressed UP");
        }
        else if(keyCode == KeyEvent.VK_DOWN){
            textField.setText("You pressed DOWN");
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //mUST IMPLEMENT ALL METHODS BUT DO NOT HAVE TO USE THEM

    }
}
