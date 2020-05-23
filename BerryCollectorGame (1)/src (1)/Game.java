
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class Game extends JFrame implements ActionListener, KeyListener {


    private boolean hasLevel2Berries, hasLevel3Berries, berry1, berry2, berry3, berry4, berry5, berry6, berry7, berry8, berry9, hasLevel1Berries = false;

    enum Direction {LEFT, RIGHT, DOWN, UP}

    private int[][] mazeArray, mazeArray2, mazeArray3;
    private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN};

    private int dialogCounter = 0, ROW = 24, COL = 24, currentLevel = 0, o, berriesCaught = 0;
    private int imageHeight = 30, imageWidth = 30, currentColumn, currentRow;


    private Random randomGenerator = new Random();
    private ArrayList<Integer> randomCoords = new ArrayList<Integer>();;

    private ImageIcon Sprite_tombstone = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//RIP.PNG");
    private ImageIcon Sprite_mycelium = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//mycelium.PNG");

    private ImageIcon Sprite_stump = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//stump.PNG");
    private ImageIcon obama = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//OBAMA.PNG");
    private ImageIcon Sprite_boulder = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//boulder.png");
    private ImageIcon Sprite_left = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//LEFTSPRITE.png");
    private ImageIcon Sprite_right = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//RIGHTSPRITE.png");
    private ImageIcon Sprite_down = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//DOWNSPRITE.png");
    private ImageIcon Sprite_up = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//UPSPRITE.png");
    private ImageIcon Sprite_berry = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//berry.PNG");
    private ImageIcon Sprite_rock = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//rock.png");
    private ImageIcon Sprite_grass2 = new ImageIcon("C://Users//krozz//BerryCollectorGame//Resources//darkrealgrass.jpg");

    private Color level2Color = new Color(70, 46, 31);
    private Color level3Color = new Color(116, 100, 103);


    private Image spriteMycelium = Sprite_mycelium.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

    private Image spriteTombstone = Sprite_tombstone.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteBoulder = Sprite_boulder.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteStump = Sprite_stump.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

    private Image spriteDown = Sprite_down.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteUp = Sprite_up.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteLeft = Sprite_left.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteRight = Sprite_right.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image rockTile = Sprite_rock.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteGrass2 = Sprite_grass2.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    private Image spriteBerry = Sprite_berry.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

    private JPanel[][] playArea = new JPanel[ROW][COL];
    private JPanel[][] playArea2 = new JPanel[ROW][COL];
    private JPanel[][] playArea3 = new JPanel[ROW][COL];

    private JPanel gridBase = new JPanel(new BorderLayout(0, 0));
    private JPanel gridBase2 = new JPanel(new BorderLayout(0, 0));
    private JPanel gridBase3 = new JPanel(new BorderLayout(0, 0));

    private JPanel grid = new JPanel(new GridBagLayout());
    private JPanel grid2 = new JPanel(new GridBagLayout());
    private JPanel grid3 = new JPanel(new GridBagLayout());

    private GridBagConstraints gbc = new GridBagConstraints();
    private GridBagConstraints gbc2 = new GridBagConstraints();
    private GridBagConstraints gbc3 = new GridBagConstraints();

    private JLabel[][] labels = new JLabel[ROW][COL];
    private JLabel[][] labels2 = new JLabel[ROW][COL];
    private JLabel[][] labels3 = new JLabel[ROW][COL];

    private JLabel obamaLabel = new JLabel();
    private CardLayout cardLayout = new CardLayout();
    private JPanel southPanel = new JPanel();
    private JLabel southPanelLabel = new JLabel();

    private JPanel southPanel2 = new JPanel();
    private JLabel southPanelLabel2 = new JLabel();

    private JPanel southPanel3 = new JPanel();
    private JLabel southPanelLabel3 = new JLabel();


    public Game() {
        super("Berry");
        //splitting them up into functions to make it "simpler" . . .
        setup();
        setupGrids();
        initiateGrids();
        setupGbc();
        addSouthPanel();
        add(gridBase, "LEVEL1");
        add(gridBase2, "LEVEL2");
        add(gridBase3, "LEVEL3");
        currentColumn = currentRow = 8; //our starting position
        labels[8][8].setIcon(new ImageIcon(spriteDown));
        addKeyListener(this);
    }
    //just sets up our grids for us
    private void setupGrids() {
        grid.setBackground(Color.BLACK);
        grid2.setBackground(Color.BLACK);
        grid3.setBackground(Color.BLACK);
        gridBase.add(grid, BorderLayout.CENTER);
        gridBase2.add(grid2, BorderLayout.CENTER);
        gridBase3.add(grid3, BorderLayout.CENTER);

        Image obamium = obama.getImage().getScaledInstance(300, 900, Image.SCALE_SMOOTH);
        obamaLabel.setIcon(new ImageIcon(obamium));


    }
    //adds southPanel to each Level
    private void addSouthPanel() {
        southPanelLabel.setText("OH NO OBAMA TOOK YOUR MOM");
        southPanelLabel.setForeground(Color.WHITE);
        southPanel.setBackground(Color.BLACK);
        southPanelLabel.setFont(new Font("Arial", Font.BOLD, 40));
        southPanel.add(southPanelLabel);
        southPanel.setSize(imageWidth * 3, imageHeight * 3);
        gridBase.add(southPanel, BorderLayout.SOUTH);

        //southPanelLabel2.setText("OH NO OBAMA TOOK YOUR MOM");
        southPanelLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        southPanel2.add(southPanelLabel2);
        southPanel2.setSize(imageWidth * 3, imageHeight * 3);
        gridBase2.add(southPanel2, BorderLayout.SOUTH);

        //southPanelLabel3.setText("OH NO OBAMA TOOK YOUR MOM");
        southPanelLabel3.setFont(new Font("Arial", Font.BOLD, 40));
        southPanel3.add(southPanelLabel3);
        southPanel3.setSize(imageWidth * 3, imageHeight * 3);
        gridBase3.add(southPanel3, BorderLayout.SOUTH);
    }
    //setup() helps us modify our JFrame to what we want it
    private void setup(){
        setSize(900, 900);
        setLayout(cardLayout);
        setIconImage(spriteGrass2);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//center
    }
    //gbc is an object associated with GridBagLayout, which is like a GridLayout but with more control
    private void setupGbc() {
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 1; gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(0, 0, 0, 0);
        gbc2.weightx = 1; gbc2.weighty = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc3.insets = new Insets(0, 0, 0, 0);
        gbc3.weightx = 1; gbc3.weighty = 1;
        gbc3.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        checkBerryCount();
        System.out.println("current COL:" + currentColumn + ", current ROW:" + currentRow + "");
        dialogCounter++;
        if (dialogCounter == 1) {
            showDialog();
        }
        int keyCode = keyEvent.getKeyCode();
        checkAllBerries();

        //if the user pressed the down key
        if (keyCode == KeyEvent.VK_DOWN) {
            //repaint();
            if ((currentColumn + 1) < ROW) {
                if (currentLevel == 0 && !isBoulder(Direction.DOWN)) {
                    labels[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn++;//update
                    labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteDown, "down")); //change the next index
                    labels[currentColumn - 1][currentRow].setIcon(new ImageIcon(spriteGrass2));
                } else if (currentLevel == 1 && !isBoulder(Direction.DOWN)) {
                    labels2[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn++;//update
                    labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteDown, "down")); //change the next index
                    labels2[currentColumn - 1][currentRow].setIcon(new ImageIcon(rockTile));

                } else if (currentLevel == 2 && !isBoulder(Direction.DOWN)) {
                    labels3[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn++;//update
                    labels3[currentColumn][currentRow].setIcon(new ImageIcon(spriteDown, "down")); //change the next index
                    labels3[currentColumn - 1][currentRow].setIcon(new ImageIcon(spriteMycelium));

                }
            } else if ((((currentColumn + 1) > (ROW - 1)) && (currentRow == 2 || currentRow == 3) && (currentLevel == 1)) && (hasLevel1Berries)) {
                labels2[currentColumn][2].setIcon(new ImageIcon(rockTile));
                labels2[currentColumn][3].setIcon(new ImageIcon(rockTile));

                switchLevels(Direction.DOWN);
                currentColumn = 0;
                labels3[currentColumn][currentRow].setIcon(new ImageIcon(spriteDown, "down"));
            }
        }
        //if the user pressed the up key
        else if (keyCode == KeyEvent.VK_UP) {
            if ((currentColumn - 1) > -1) {//doesn't go past zero
                if (currentLevel == 0 && !isBoulder(Direction.UP)) {
                    labels[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn--;//update
                    labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteUp, "up")); //change the next index
                    labels[currentColumn + 1][currentRow].setIcon(new ImageIcon(spriteGrass2));

                } else if (currentLevel == 1 && !isBoulder(Direction.UP)) {
                    labels2[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn--;//update
                    labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteUp, "up")); //change the next index
                    labels2[currentColumn + 1][currentRow].setIcon(new ImageIcon(rockTile));
                } else if (currentLevel == 2 && !isBoulder(Direction.UP)) {
                    labels3[currentColumn][currentRow].setIcon(null); //change the old index
                    currentColumn--;//update
                    labels3[currentColumn][currentRow].setIcon(new ImageIcon(spriteUp, "up")); //change the next index
                    labels3[currentColumn + 1][currentRow].setIcon(new ImageIcon(spriteMycelium));
                }
            } else if (((currentColumn - 1) == -1) && (currentRow == 2 || currentRow == 3) && (currentLevel == 2)) {
                labels3[currentColumn][2].setIcon(new ImageIcon(spriteMycelium));
                labels3[currentColumn][2].setIcon(new ImageIcon(spriteMycelium));

                switchLevels(Direction.UP);
                currentColumn = COL - 1;
                labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteUp, "up"));
            }
        }
        //if the user pressed the left key
        else if (keyCode == KeyEvent.VK_LEFT) {
            if ((currentRow - 1) > -1) {//doesn't go past zero
                if (currentLevel == 0 && !isBoulder(Direction.LEFT)) {
                    labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteGrass2)); //change the old index
                    currentRow--;//update
                    labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteLeft, "left")); //change the old index
                    labels[currentColumn][currentRow + 1].setIcon(new ImageIcon(spriteGrass2)); //change the next index

                } else if (currentLevel == 1 && !isBoulder(Direction.LEFT)) {
                    labels2[currentColumn][currentRow].setIcon(null); //change the old index
                    currentRow--;//update
                    labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteLeft, "left")); //change the old index
                    labels2[currentColumn][currentRow + 1].setIcon(new ImageIcon(rockTile)); //change the next index
                } else if (currentLevel == 2 && !isBoulder(Direction.LEFT)) {
                    labels3[currentColumn][currentRow].setIcon(null); //change the old index
                    currentRow--;//update
                    labels3[currentColumn][currentRow].setIcon(new ImageIcon(spriteLeft, "left")); //change the next index
                    labels3[currentColumn][currentRow + 1].setIcon(new ImageIcon(spriteMycelium)); //change the next index
                }
            } else if (((currentRow + 1) < (COL - 1)) && (currentColumn == 0 || currentColumn == 1) && currentLevel == 1) {
                labels2[currentColumn][currentRow].setIcon(new ImageIcon(rockTile));
                switchLevels(Direction.LEFT);
                currentRow = 23;
                labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteLeft, "left"));
            }

        }
        //if the user pressed the right key
        else if (keyCode == KeyEvent.VK_RIGHT) {
            if ((currentRow + 1) < COL) {
                if (currentLevel == 0 && !isBoulder(Direction.RIGHT)) {
                    labels[currentColumn][currentRow].setIcon(null); //change the old index
                    currentRow++;//update
                    labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteRight, "right")); //change the next index
                    labels[currentColumn][currentRow - 1].setIcon(new ImageIcon(spriteGrass2)); //change the LAST index
                } else if (currentLevel == 1 && !isBoulder(Direction.RIGHT)) {
                    labels2[currentColumn][currentRow].setIcon(null); //change the old index
                    currentRow++;//update
                    labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteRight, "right")); //change the next index
                    labels2[currentColumn][currentRow - 1].setIcon(new ImageIcon(rockTile)); //change the next index
                } else if (currentLevel == 2 && !isBoulder(Direction.RIGHT)) {
                    labels3[currentColumn][currentRow].setIcon(null); //change the old index
                    currentRow++;//update
                    labels3[currentColumn][currentRow].setIcon(new ImageIcon(spriteRight, "right")); //change the next index
                    labels3[currentColumn][currentRow - 1].setIcon(new ImageIcon(spriteMycelium)); //change the next index
                }
            } else if (((currentRow + 1) > (COL - 1)) && (currentColumn == 0 || currentColumn == 1) && (currentLevel == 0) && (hasLevel1Berries)) {
                labels[currentColumn][currentRow].setIcon(new ImageIcon(spriteGrass2));
                switchLevels(Direction.RIGHT);
                currentRow = 0;
                labels2[currentColumn][currentRow].setIcon(new ImageIcon(spriteRight, "right"));
            } else if (((currentRow + 1) > (ROW - 1)) && (currentColumn == 0 || currentColumn == 1) && (currentLevel == 0) && (!hasLevel1Berries)) {
                //we had to use Timer because Swing is weird with threads and won't really work
                Timer timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (o < colors.length) {
                            southPanel.setBackground(colors[o]);
                            southPanelLabel.setText("YOU NEED TO GET ALL THE BERRIES");
                            grid.setBackground(colors[o].darker().darker().darker().darker());
                            southPanelLabel.setForeground(colors[o].darker().darker());
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                        o++;
                    }
                });
                timer.stop();
                o = 0;
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        }

        //if they press the space button
        else if (keyCode == KeyEvent.VK_SPACE) {
        }
    }

    private void checkAllBerries() {
        //checking to see if we caught LEVEL 1
        Timer timer2;
        if ((currentColumn == randomCoords.get(0)) && (currentRow == randomCoords.get(1)) && currentLevel == 0) {

            if(!berry1){
                berriesCaught++;
            }
            berry1 = true;
            southPanelLabel.setText("YOU HAVE " + berriesCaught);
            southPanel.setBackground(Color.GREEN);

        }
        //checking to see if we caught berry2
        else if ((currentColumn == randomCoords.get(2)) && (currentRow == randomCoords.get(3)) && currentLevel == 0) {
            if(!berry2){
                berriesCaught++;
            }
            berry2 = true;
            southPanelLabel.setText("YOU HAVE " + berriesCaught);
            southPanel.setBackground(Color.GREEN);
            timer2 = new Timer(1000, e -> {
                southPanel.setBackground(Color.BLACK);
                southPanelLabel.setForeground(Color.white);
                southPanelLabel.setText("Now go get the other berries...");
            });


            if (!timer2.isRunning()) {
                timer2.start();
            }
        }
        //checking to see if we caught berry3
        else if ((currentColumn == randomCoords.get(4)) && (currentRow == randomCoords.get(5)) && currentLevel == 0) {
            if(!berry3){
                berriesCaught++;
            }
            berry3 = true;
            southPanelLabel.setText("YOU HAVE " + berriesCaught);
            southPanel.setBackground(Color.GREEN);
            timer2 = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    southPanel.setBackground(Color.BLACK);
                    southPanelLabel.setForeground(Color.white);
                    southPanelLabel.setText("Now go get the other berries...");
                }
            });
            if (!timer2.isRunning()) {
                timer2.start();
            }
        }


        //checking LEVEL 2
        if ((currentColumn == randomCoords.get(0)) && (currentRow == randomCoords.get(1)) && currentLevel == 1) {

            if(!berry4){
                berriesCaught++;
            }
            berry4 = true;
            southPanelLabel2.setText("YOU HAVE " + berriesCaught);
            southPanel2.setBackground(Color.GREEN);

        }
        //checking to see if we caught berry2
        else if ((currentColumn == randomCoords.get(2)) && (currentRow == randomCoords.get(3)) && currentLevel == 1) {
            if(!berry5){
                berriesCaught++;
            }
            berry5 = true;
            southPanelLabel2.setText("YOU HAVE " + berriesCaught);
            southPanel2.setBackground(Color.GREEN);
            timer2 = new Timer(1000, e -> {
                southPanel2.setBackground(Color.BLACK);
                southPanelLabel2.setForeground(Color.white);
                southPanelLabel2.setText("Now go get the other berries...");
            });
            if (!timer2.isRunning()) {
                timer2.start();
            }
        }
        //checking to see if we caught berry6
        else if ((currentColumn == randomCoords.get(4)) && (currentRow == randomCoords.get(5)) && currentLevel == 1) {
            if(!berry6){
                berriesCaught++;
            }
            berry6 = true;
            southPanelLabel3.setText("YOU HAVE " + berriesCaught);
            southPanel3.setBackground(Color.GREEN);
            timer2 = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    southPanel3.setBackground(Color.BLACK);
                    southPanelLabel3.setForeground(Color.white);
                    southPanelLabel3.setText("Now go get the other berries...");
                }
            });
            if (!timer2.isRunning()) {
                timer2.start();
            }
        }
        //checking LEVEL 3
        if ((currentColumn == randomCoords.get(0)) && (currentRow == randomCoords.get(1)) && currentLevel == 2) {

            if(!berry7){
                berriesCaught++;
            }
            berry7 = true;
            southPanelLabel3.setText("YOU HAVE " + berriesCaught);
            southPanel3.setBackground(Color.GREEN);

        }
        //checking to see if we caught berry2
        else if ((currentColumn == randomCoords.get(2)) && (currentRow == randomCoords.get(3)) && currentLevel == 2) {
            if(!berry8){
                berriesCaught++;
            }
            berry8 = true;
            southPanelLabel3.setText("YOU HAVE " + berriesCaught);
            southPanel3.setBackground(Color.GREEN);
            timer2 = new Timer(1000, e -> {
                southPanel3.setBackground(Color.BLACK);

            });
            if (!timer2.isRunning()) {
                timer2.start();
            }
        }
        //checking to see if we caught berry6
        else if ((currentColumn == randomCoords.get(4)) && (currentRow == randomCoords.get(5)) && currentLevel == 1) {
            if(!berry6){
                berriesCaught++;
            }
            berry6 = true;
            southPanelLabel3.setText("YOU HAVE " + berriesCaught);
            southPanel3.setBackground(Color.GREEN);
            timer2 = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    southPanel3.setBackground(Color.BLACK);
                    southPanelLabel3.setForeground(Color.white);
                    southPanelLabel3.setText("Now go get the other berries...");
                }
            });
            if (!timer2.isRunning()) {
                timer2.start();
            }
        }



    }

    private boolean isBoulder(Direction direction) {
        boolean flag = false;
        if(currentLevel == 0){
            if (direction == Direction.DOWN) {
            if (mazeArray[currentColumn + 1][currentRow] == 1 || mazeArray[currentColumn + 1][currentRow] == 2 || mazeArray[currentColumn + 1][currentRow] == 3 || mazeArray[currentColumn + 1][currentRow] == 4) {
                flag = true;
            } else {
                flag = false;
            }
        } else if (direction == Direction.UP) {
            if (mazeArray[currentColumn - 1][currentRow] == 1 || mazeArray[currentColumn - 1][currentRow] == 2 || mazeArray[currentColumn - 1][currentRow] == 3 || mazeArray[currentColumn - 1][currentRow] == 4) {
                flag = true;
            } else {
                flag = false;
            }
        } else if (direction == Direction.LEFT) {
            if (mazeArray[currentColumn][currentRow - 1] == 1 || mazeArray[currentColumn][currentRow - 1] == 2 || mazeArray[currentColumn][currentRow - 1] == 3 || mazeArray[currentColumn][currentRow - 1] == 4) {
                flag = true;
            } else {
                flag = false;
            }
        } else if (direction == Direction.RIGHT) {

            if (mazeArray[currentColumn][currentRow + 1] == 1 || mazeArray[currentColumn][currentRow + 1] == 2 || mazeArray[currentColumn][currentRow + 1] == 3 || mazeArray[currentColumn][currentRow + 1] == 4) {
                flag = true;
            } else {
                flag = false;
            }
        }

        }
        else if(currentLevel == 1){
            if (direction == Direction.DOWN) {
                if (mazeArray2[currentColumn + 1][currentRow] == 1 || mazeArray2[currentColumn + 1][currentRow] == 2 || mazeArray2[currentColumn + 1][currentRow] == 3 || mazeArray2[currentColumn + 1][currentRow] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.UP) {
                if (mazeArray2[currentColumn - 1][currentRow] == 1 || mazeArray2[currentColumn - 1][currentRow] == 2 || mazeArray2[currentColumn - 1][currentRow] == 3 || mazeArray2[currentColumn - 1][currentRow] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.LEFT) {
                if (mazeArray2[currentColumn][currentRow - 1] == 1 || mazeArray2[currentColumn][currentRow - 1] == 2 || mazeArray2[currentColumn][currentRow - 1] == 3 || mazeArray2[currentColumn][currentRow - 1] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.RIGHT) {

                if (mazeArray2[currentColumn][currentRow + 1] == 1 || mazeArray2[currentColumn][currentRow + 1] == 2 || mazeArray2[currentColumn][currentRow + 1] == 3 || mazeArray2[currentColumn][currentRow + 1] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

        }

        else if(currentLevel == 2){
            if (direction == Direction.DOWN) {
                if (mazeArray3[currentColumn + 1][currentRow] == 1 || mazeArray3[currentColumn + 1][currentRow] == 2 || mazeArray3[currentColumn + 1][currentRow] == 3 || mazeArray3[currentColumn + 1][currentRow] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.UP) {
                if (mazeArray3[currentColumn - 1][currentRow] == 1 || mazeArray3[currentColumn - 1][currentRow] == 2 || mazeArray3[currentColumn - 1][currentRow] == 3 || mazeArray3[currentColumn - 1][currentRow] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.LEFT) {
                if (mazeArray3[currentColumn][currentRow - 1] == 1 || mazeArray3[currentColumn][currentRow - 1] == 2 || mazeArray3[currentColumn][currentRow - 1] == 3 || mazeArray3[currentColumn][currentRow - 1] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else if (direction == Direction.RIGHT) {

                if (mazeArray3[currentColumn][currentRow + 1] == 1 || mazeArray3[currentColumn][currentRow + 1] == 2 || mazeArray3[currentColumn][currentRow + 1] == 3 || mazeArray[currentColumn][currentRow + 1] == 4) {
                    flag = true;
                } else {
                    flag = false;
                }
            }

        }
        return flag;
    }

    private void checkBerryCount() {
        if(berry1 && berry2 && berry3) {
            hasLevel1Berries = true;
        }
         if(berry4 && berry5 && berry6){
             hasLevel2Berries = true;
         }
        if(berry7 && berry8 && berry9){
            hasLevel3Berries = true;
        }
        if(hasLevel1Berries && hasLevel2Berries && hasLevel3Berries){
            southPanelLabel3.setText("CONGRATULATIONS! YOU GOT HER BACK!!!!");
        }

    }
    private void removeObstacles(){


    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    private void switchLevels(Direction direction) {

        if (direction == Direction.RIGHT) {
            cardLayout.show(getContentPane(), "LEVEL2");
            currentLevel++;

        } else if (direction == Direction.LEFT) {
            cardLayout.show(getContentPane(), "LEVEL1");
            currentLevel--;

        } else if (direction == Direction.DOWN) {
            cardLayout.show(getContentPane(), "LEVEL3");
            currentLevel++;
        } else if (direction == Direction.UP) {
            cardLayout.show(getContentPane(), "LEVEL2");
            currentLevel--;
        }
    }

    private void initiateGrids() {
        for (int row_ = 0; row_ < ROW; row_++) {
            for (int col_ = 0; col_ < COL; col_++) {
                //LEVEL 1
                playArea[row_][col_] = new JPanel(new GridLayout());
                playArea[row_][col_].setBackground(Color.GREEN.darker().darker().darker().darker());
                gbc.gridx = col_;
                gbc.gridy = row_;
                grid.add(playArea[row_][col_], gbc);
                labels[row_][col_] = new JLabel();
                labels[row_][col_].setBorder(null);
                labels[row_][col_].setIcon(new ImageIcon(spriteGrass2));
                playArea[row_][col_].add(labels[row_][col_]);

                //LEVEL 2
                playArea2[row_][col_] = new JPanel(new GridLayout());
                playArea2[row_][col_].setBackground(level2Color);
                gbc2.gridx = col_;
                gbc2.gridy = row_;
                grid2.add(playArea2[row_][col_], gbc2);
                labels2[row_][col_] = new JLabel();
                labels2[row_][col_].setBorder(null);
                labels2[row_][col_].setIcon(new ImageIcon(rockTile));
                playArea2[row_][col_].add(labels2[row_][col_]);


                //LEVEL 3
                playArea3[row_][col_] = new JPanel(new GridLayout());
                playArea3[row_][col_].setBackground(level3Color);
                gbc3.gridx = col_;
                gbc3.gridy = row_;
                grid3.add(playArea3[row_][col_], gbc3);
                labels3[row_][col_] = new JLabel();
                labels3[row_][col_].setIcon(new ImageIcon(spriteMycelium));
                playArea3[row_][col_].add(labels3[row_][col_]);
            }
        }
        generateBoulders();
        generateBerries();
    }

    private void generateBoulders() {
        MazeGenerator maze1 = new MazeGenerator(ROW, COL);
        mazeArray = maze1.returnMaze();
        MazeGenerator maze2 = new MazeGenerator(ROW, COL);
        mazeArray2 = maze2.returnMaze();
        MazeGenerator maze3 = new MazeGenerator(ROW, COL);
        mazeArray3 = maze3.returnMaze();

        //generate the first level boulders
        for (int i = 0; i < mazeArray.length; i++) {
            for (int o = 0; o < mazeArray.length; o++) {
                if (mazeArray[i][o] < 5) {
                    labels[i][o].setIcon(new ImageIcon(spriteStump));
                }
            }
        }
        //generate the first level boulders
        for (int i = 0; i < mazeArray2.length; i++) {
            for (int o = 0; o < mazeArray2.length; o++) {
                if (mazeArray2[i][o] < 5) {
                     labels2[i][o].setIcon(new ImageIcon(spriteBoulder));
                 }
            }
        }

        //generate the first level boulders
        for (int i = 0; i < mazeArray3.length; i++) {
            for (int o = 0; o < mazeArray3.length; o++) {
                if (mazeArray3[i][o] < 5) {
                     labels3[i][o].setIcon(new ImageIcon(spriteTombstone));
                 }
            }
        }
    }

    private void generateBerries() {
        int random1x = 0, random2x = 0;
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 6; x++) {
                random1x = randomGenerator.nextInt(ROW);
                randomCoords.add(random1x);

            }
            if (i == 0) {
                labels[randomCoords.get(0)][randomCoords.get(1)].setIcon(new ImageIcon(spriteBerry));
                labels[randomCoords.get(2)][randomCoords.get(3)].setIcon(new ImageIcon(spriteBerry));
                labels[randomCoords.get(4)][randomCoords.get(5)].setIcon(new ImageIcon(spriteBerry));
            }
            if (i == 1) {
                labels2[randomCoords.get(0)][randomCoords.get(1)].setIcon(new ImageIcon(spriteBerry));
                labels2[randomCoords.get(2)][randomCoords.get(3)].setIcon(new ImageIcon(spriteBerry));
                labels2[randomCoords.get(4)][randomCoords.get(5)].setIcon(new ImageIcon(spriteBerry));

            }
            if (i == 2) {
                labels3[randomCoords.get(0)][randomCoords.get(1)].setIcon(new ImageIcon(spriteBerry));
                labels3[randomCoords.get(2)][randomCoords.get(3)].setIcon(new ImageIcon(spriteBerry));
                labels3[randomCoords.get(4)][randomCoords.get(5)].setIcon(new ImageIcon(spriteBerry));

            }
        }
    }


    private void showDialog() {
        String dialog1 = "Uh oh! Obama took your mom! You need to collect all the berries on each level to get your mom back!";
        String two = "";
        JOptionPane.showMessageDialog(null, dialog1, "HEY", JOptionPane.INFORMATION_MESSAGE);
        southPanelLabel.setText("GET ALL THE BERRIES TO SAVE HER!!");
    }
}
