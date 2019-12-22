package com.georgetsak.sorry.viewer;

import com.georgetsak.sorry.controller.Controller;
import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.square.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {

    private JPanel gamePanel;
    private JPanel optionsPanel;

    private JButton newGameButton;
    private JButton exitButton;
    private JButton pickCardButton;
    private JButton forfeitMoveButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    private JButton[] boardSquaresButtons;
    private JLabel playerPlayingLabel;
    private JLabel cardsLeftLabel;

    private Square origin;

    /**
     * <b>Constructor</b> constructs the View and initializes and displays the window
     * <b>Postcondition</b> a View is created and window along with its inner main components like panels are initialized and displayed
     */
    public View(){
        JFrame frame = new JFrame("Sorry! 4186");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1024, 605);

        Image imageBackground = null;
        Image imageBoard = null;
        Image imageLogo = null;

        try {
            imageBackground = ImageIO.read(new File("src/assets/background.jpg"));
            imageBoard = ImageIO.read(new File("src/assets/board.jpg"));
            imageLogo = ImageIO.read(new File("src/assets/sorry_logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(imageBackground == null || imageBoard == null || imageLogo == null){
            System.err.println("Could not load images. Aborting...");
            System.exit(-1);
        }

        JLabel background = new JLabel(new ImageIcon(imageBackground));
        JLabel board = new JLabel(new ImageIcon(imageBoard));
        JLabel sorryLogo = new JLabel(new ImageIcon(imageLogo));

        JPanel mainPanel = new JPanel(null);
        gamePanel = new JPanel(null);
        optionsPanel = new JPanel(null);

        gamePanel.setBounds(0, 0, 576, 576);

        sorryLogo.setBounds(188, 188, 200, 200);

        initBoardSquares();

        gamePanel.add(sorryLogo);
        gamePanel.add(board);
        background.setBounds(0, 0, 1024, 576);
        board.setBounds(0, 0, 576, 576);

        initGui();

        mainPanel.add(gamePanel);
        mainPanel.add(background);

        frame.add(mainPanel);
        frame.setVisible(true);

        while(true);
        //TODO initiate images and panels
    }

    /**
     * <b>Transformer(mutative)</b> Initializes and displays the gui buttons except for the square ones
     * <b>Postcondition</b> all buttons but square buttons are initialized and displayed into the gui
     */
    public void initGui(){

    }

    /**
     * <b>Transformer(mutative)</b> Initializes and displays the square buttons
     * <b>Postcondition</b> square buttons are initialized and displayed into gui
     */
    public void initBoardSquares(){
        Image squareImage = null;
        Image squareSliderStartRedImage = null;
        Image squareSliderMidRedImage = null;
        Image squareSliderEndRedImage = null;
        Image squareSliderStartBlueImage = null;
        Image squareSliderMidBlueImage = null;
        Image squareSliderEndBlueImage = null;
        Image squareSliderStartYellowImage = null;
        Image squareSliderMidYellowImage = null;
        Image squareSliderEndYellowImage = null;
        Image squareSliderStartGreenImage = null;
        Image squareSliderMidGreenImage = null;
        Image squareSliderEndGreenImage = null;
        Image squareRed = null;
        Image squareYellow = null;
        Image squareHomeRed = null;
        Image squareHomeYellow = null;
        Image squareStartRed = null;
        Image squareStartYellow = null;

        try {
            squareImage = ImageIO.read(new File("src/assets/square.png"));
            squareSliderStartRedImage = ImageIO.read(new File("src/assets/slider_start_red.png"));
            squareSliderMidRedImage = ImageIO.read(new File("src/assets/slider_mid_red.png"));
            squareSliderEndRedImage = ImageIO.read(new File("src/assets/slider_end_red.png"));
            squareSliderStartBlueImage = ImageIO.read(new File("src/assets/slider_start_blue.png"));
            squareSliderMidBlueImage = ImageIO.read(new File("src/assets/slider_mid_blue.png"));
            squareSliderEndBlueImage = ImageIO.read(new File("src/assets/slider_end_blue.png"));
            squareSliderStartYellowImage = ImageIO.read(new File("src/assets/slider_start_yellow.png"));
            squareSliderMidYellowImage = ImageIO.read(new File("src/assets/slider_mid_yellow.png"));
            squareSliderEndYellowImage = ImageIO.read(new File("src/assets/slider_end_yellow.png"));
            squareSliderStartGreenImage = ImageIO.read(new File("src/assets/slider_start_green.png"));
            squareSliderMidGreenImage = ImageIO.read(new File("src/assets/slider_mid_green.png"));
            squareSliderEndGreenImage = ImageIO.read(new File("src/assets/slider_end_green.png"));
            squareRed = ImageIO.read(new File("src/assets/square_red.png"));
            squareYellow = ImageIO.read(new File("src/assets/square_yellow.png"));
            squareHomeRed = ImageIO.read(new File("src/assets/home_red.png"));
            squareHomeYellow = ImageIO.read(new File("src/assets/home_yellow.png"));
            squareStartRed = ImageIO.read(new File("src/assets/start_red.png"));
            squareStartYellow = ImageIO.read(new File("src/assets/start_yellow.png"));
        }catch (Exception e){
            System.err.println("Could not load one or more of the square images. Aborting...");
            e.printStackTrace();
            //System.exit(-1);
        }

        boardSquaresButtons = new JButton[74];

        //top side (IDs 11-26) and bottom side (IDs 56-41) buttons
        for(int i = 0; i < 16; i++){

            boardSquaresButtons[i + 11] = new JButton();
            boardSquaresButtons[i + 11].setBounds(i*36 + 1, 0, 34, 34);

            boardSquaresButtons[56 - i] = new JButton();
            boardSquaresButtons[56 - i].setBounds(i*36 + 1, 540, 34, 34);

        }

        //left side (IDs: 10 - 0 & 59 - 57) and right side (IDs: 27-40) buttons
        for(int i = 0; i < 14; i++){

            if(i <= 10){
                boardSquaresButtons[10 - i] = new JButton();
                boardSquaresButtons[10 - i].setBounds(1, 36 + i*36, 34, 34);
            }else{
                boardSquaresButtons[59 - (i - 11)] = new JButton();
                boardSquaresButtons[59 - (i - 11)].setBounds(1, 36 + i*36, 34, 34);
            }

            boardSquaresButtons[27 + i] = new JButton();
            boardSquaresButtons[27 + i].setBounds(541, 36 + i*36, 34, 34);
        }

        //red safezone (IDs: 61 - 66)
        for(int i = 0; i < 5; i++){
            boardSquaresButtons[i + 61] = new JButton();
            boardSquaresButtons[i + 61].setBounds(73, 36 + i*36, 34, 34);
        }

        //yellow safezone (IDs: 68 - 73)
        for(int i = 0; i < 5; i++) {
            boardSquaresButtons[i + 68] = new JButton();
            boardSquaresButtons[i + 68].setBounds(469, 504 - i * 36, 34, 34);
        }

        //red home
        boardSquaresButtons[66] = new JButton();
        boardSquaresButtons[66].setBounds(57, 216, 68, 68);

        //yellow home
        boardSquaresButtons[73] = new JButton();
        boardSquaresButtons[73].setBounds(452, 290, 68, 68);

        //red start
        boardSquaresButtons[60] = new JButton();
        boardSquaresButtons[60].setBounds(128 ,36, 68, 68);

        //yellow start
        boardSquaresButtons[67] = new JButton();
        boardSquaresButtons[67].setBounds(379 ,470, 68, 68);

        if(false) {//set true to show the IDs of the buttons instead of their icons
            for (int i = 0; i <= 73; i++) {
                if(boardSquaresButtons[i] == null)continue;
                boardSquaresButtons[i].setText(String.valueOf(i));
                boardSquaresButtons[i].setBorder(null);
                boardSquaresButtons[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
                gamePanel.add(boardSquaresButtons[i]);
            }
        }else{
            for(int i = 0; i <= 73; i++){
                if(boardSquaresButtons[i] == null)continue;

                switch (i){
                    case 57:
                    case 5:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartGreenImage));
                        break;
                    case 12:
                    case 20:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartRedImage));
                        break;
                    case 27:
                    case 35:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartBlueImage));
                        break;
                    case 42:
                    case 50:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderStartYellowImage));
                        break;
                    case 13:
                    case 14:
                    case 21:
                    case 22:
                    case 23:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidRedImage));
                        break;
                    case 28:
                    case 29:
                    case 36:
                    case 37:
                    case 38:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidBlueImage));
                        break;
                    case 43:
                    case 44:
                    case 51:
                    case 52:
                    case 53:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidYellowImage));
                        break;
                    case 58:
                    case 59:
                    case 6:
                    case 7:
                    case 8:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderMidGreenImage));
                        break;
                    case 15:
                    case 24:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndRedImage));
                        break;
                    case 30:
                    case 39:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndBlueImage));
                        break;
                    case 45:
                    case 54:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndYellowImage));
                        break;
                    case 0:
                    case 9:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareSliderEndGreenImage));
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareRed));
                        break;
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareYellow));
                        break;
                    case 66:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareHomeRed));
                        break;
                    case 73:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareHomeYellow));
                        break;
                    case 60:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareStartRed));
                        break;
                    case 67:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareStartYellow));
                        break;
                    default:
                        boardSquaresButtons[i].setIcon(new ImageIcon(squareImage));
                }
                gamePanel.add(boardSquaresButtons[i]);

            }
        }

    }

    /**
     * Displays a confirm dialog windows with {@code title} title and {@code message} message and returns an integer depending on the user input
     * @param title the title of the dialog window
     * @param message the message of the dialog window
     * @return an int depending on the user input; 1 for yes and 0 for no
     */
    public int displayConfirmDialog(String title, String message){
        return 0;
    }

    private class squareButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after a square button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after a square button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }

    private class newGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the new game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the new game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class saveGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the save game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the save game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class loadGameButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the load game button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the load game button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class exitButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the exit button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the exit button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class pickCardButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the pick card button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the pick card button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class forfeitMoveButtonListener implements ActionListener{
        /**
         * <b>transformer(mutative)
         * </b>:doing some action after the forfeit move button has been pressed<br />
         * <p><b>Postcondition:</b> doing some action after the forfeit move button has been pressed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
