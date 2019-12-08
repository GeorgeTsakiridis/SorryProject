package com.georgetsak.sorry.viewer;

import com.georgetsak.sorry.model.board.square.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private Image imageBackground;
    private Image imageBoard;

    private JPanel gamePanel;
    private JPanel optionsPanel;

    private JButton newGameButton;
    private JButton exitButton;
    private JButton pickCardButton;
    private JButton forfeitMoveButton;
    private JButton saveGameButton;
    private JButton loadGameButton;
    private JButton[] boardSquaresButtons = new JButton[73];
    private JLabel playerPlayingLabel;
    private JLabel cardsLeftLabel;

    private Square origin;
    private Square destination;

    /**
     * <b>Constructor</b> constructs the View and initializes and displays the window
     * <b>Postcondition</b> a View is created and window along with its inner main components like panels are initialized and displayed
     */
    public View(){

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
