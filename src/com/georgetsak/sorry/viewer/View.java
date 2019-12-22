package com.georgetsak.sorry.viewer;

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

    private Image squareImage;

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
        squareImage = null;

        try {
            imageBackground = ImageIO.read(new File("src/assets/background.jpg"));
            imageBoard = ImageIO.read(new File("src/assets/board.jpg"));
            imageLogo = ImageIO.read(new File("src/assets/sorry_logo.png"));
            squareImage = ImageIO.read(new File("src/assets/square.png"));
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
        //TODO initiate all buttons but squares

        for(int i = 0; i < 16; i++){
            JButton test = new JButton(new ImageIcon(squareImage));
            JButton test2 = new JButton(new ImageIcon(squareImage));

            test.setBounds(i*36 + 1, 0, 34, 34);
            test2.setBounds(i*36 + 1, 540, 34, 34);
            gamePanel.add(test);
            gamePanel.add(test2);
        }

        for(int i = 0; i < 14; i++){
            JButton test = new JButton(new ImageIcon(squareImage));
            JButton test2 = new JButton(new ImageIcon(squareImage));

            test.setBounds(1, 36 + i*36, 34, 34);
            test2.setBounds(541, 36 + i*36, 34, 34);
            gamePanel.add(test);
            gamePanel.add(test2);
        }

    }

    /**
     * <b>Transformer(mutative)</b> Initializes and displays the square buttons
     * <b>Postcondition</b> square buttons are initialized and displayed into gui
     */
    public void initBoardSquares(){
        //TODO initiate squares
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
