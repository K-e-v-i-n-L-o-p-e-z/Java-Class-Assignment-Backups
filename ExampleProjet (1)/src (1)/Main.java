import javax.swing.*;

public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame("GAME EXAMPLe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        frame.add(game);
        frame.setSize(500,500);

        frame.setVisible(true);
    }
}
