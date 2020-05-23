import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.security.Key;

public class Game extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(5, this);
    double x = 0, y = 0, velx = 0, vely = 0;
    ImageIcon Sprite_left = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//leftsprite.png");
    Image spriteLeft = Sprite_left.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);

    public Game(){
        t.start();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(x,y,40,40));
//        g2.fill((Shape) Sprite_left);
        //Sprite_left.paintIcon(this,g,x,y);
    }





    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
        x += velx;
        y += vely;
    }

    public void up(){
        vely = -1.5;
        velx = 0;
    }
    public void down(){
        vely = 1.5;
        velx = 0;
    }
    public void left(){
        velx = -1.5;
        vely = 0;
    }
    public void right(){
        velx = 1.5;
        vely = 0;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();

        if(code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
        if(code == KeyEvent.VK_LEFT){
            left();
        }
        if(code == KeyEvent.VK_RIGHT){
            right();
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        velx = 0;
        vely = 0;
    }
}
