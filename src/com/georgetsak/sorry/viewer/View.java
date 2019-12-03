package com.georgetsak.sorry.viewer;

import com.georgetsak.sorry.model.board.squares.Square;

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
    private JButton[] boardSquaresButtons = new JButton[73];
    private JLabel playerPlayingLabel;
    private JLabel cardsLeftLabel;

    private Square origin;
    private Square destination;

    public View(){

    }

    public void initGui(){

    }

    public void initBoardSquares(){

    }

    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     * <b>postcondition</b>: constructs a new Controller,with new 4 players,new
     * instances of Turn Class , Round Class and Sullogi Class and initialize
     * some int or boolean variables.So,is responsible for creating a new game and
     * initializing it.
     */
    public int displayConfirmDialog(String title, String message){
        return 0;
    }

    private class squareButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class newGameButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class exitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class pickCardButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class forfeitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
