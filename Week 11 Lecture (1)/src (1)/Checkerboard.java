import javax.swing.*;
import java.awt.*;

public class Checkerboard extends JFrame {
    private final int ROWS = 8;
    private final int COLS = 8;
    private final int size = 300;

    //this pane will contain the grid full of panels
    private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, 2, 2));
    // array of 64 Jpanels
    private JPanel[] panel = new JPanel[64];//init array
    private Color color1 = Color.WHITE;
    private Color color2 = Color.BLUE;
    private Color tempColor;

    public Checkerboard() {
        super("Checkers");
        setSize(size, size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(pane);//add it directly to the pane

        for (int x = 0; x < 64; ++x) {
            panel[x] = new JPanel();//init individual panels
            pane.add(panel[x]); // add the panel to the grid
            if (x % COLS == 0) {//if even column
                tempColor = color1;
                color1 = color2;
                color2 = tempColor;
            }
            if (x % 2 == 0) {

                panel[x].setBackground(color1);
            } else {
                panel[x].setBackground(color2);

            }

        }
    }
}
