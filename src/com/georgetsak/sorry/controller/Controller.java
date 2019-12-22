package com.georgetsak.sorry.controller;

import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.Player;
import com.georgetsak.sorry.model.Board;
import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.square.Square;
import com.georgetsak.sorry.model.card.Card;
import com.georgetsak.sorry.model.card.Deck;
import com.georgetsak.sorry.viewer.View;

import java.io.File;
import java.util.Random;

/**
 * Controller class handles and coordinates all the other classes.
 */
public class Controller {

    private View view;

    private Player playerRed;
    private Player playerYellow;
    private Player playerPlaying;

    private Board board;
    private Deck deck;
    private Card currentCard;
    private boolean pickedCard;
    private boolean obeyedCard;
    private boolean vsComputer;

    /**
     * <b>Constructor</b> constructs a new Controller and initializes all components necessary to start the game
     * <b>Postcondition</b> creates a new Controller and initialiazes all components necessary to start the game; the two players, the board, the deck and the window. Also
     * picks a random player to start the game and sets some boolean values
     */
    public Controller(){
        board = new Board();
        deck = new Deck();

        playerRed = new Player(Color.RED);
        playerYellow = new Player(Color.YELLOW);
        playerPlaying = new Random().nextBoolean() ? playerRed : playerYellow;

        for (int i = 0; i < 2; i++) {
            playerRed.addPawn(new Pawn(Color.RED));
            playerYellow.addPawn(new Pawn(Color.YELLOW));
        }

        pickedCard = false;
        obeyedCard = false;
        currentCard = null;

        view = new View();
        vsComputer = view.displayConfirmDialog("Opponent?", "Play against computer ?") == 1;
    }

    /**
     * <b>Transformer(mutative)<b/> changes the turn to the next player
     * <b>Postcondition<b/> the turn is given to the next player
     */
    private void nextTurn(){

    }

    /**
     * <b>Observer</b> returns true if the player cannot execute the card's instruction; false otherwise
     * <b>Postcondition<b/> true is returned if the player cannot execute the card's instruction; false otherwise
     * @return true is returned if the player cannot execute the card's instruction; false otherwise
     */
    public boolean canPlayerFold(){
        return false;
    }

    /**
     * <b>Observer</b> returns true or false depending on whether or not the player can pick a card
     * <b>Postcondition</b> true is returned if the player can pick a card; false otherwise
     * @return true if the player can pick a card or false if the player cannot pick a card
     */
    public boolean canPlayerPickCard(){
        return false;
    }

    /**
     * <b>Transformer(mutative)</b> Moves the pawn on top of {@code origin} to {@code destination} if the move is valid.
     * <b>Precondition<b/> {@code origin} and {@code destination} are not null
     * <b>Postcondition<b/> The pawn on top of {@code origin} is moved to {@code destination} if the move is valid
     * @param origin The square the pawn to move is at
     * @param destination The square the pawn is requested to move
     */
    public void movePawnOnSquareTo(Square origin, Square destination){

    }

    /**
     * <b>Transformer(mutative)</b> Picks a card from the deck for the player currently playing. If deck has no cards a new deck is generated
     * <b>Postcondition<b/> a new card is picked for the currently playing player
     */
    public void pickCard(){

    }

    /**
     * <b>Observer</b> checks if the pawn on {@code square} can move by {@code steps} steps
     * <b>Precondition</b> a non null {@code square} and a non zero {@code steps}, {@code square} must have a pawn on it
     * <b>Postcondition</b> returns true depending on whether or not the pawn on {@code square} can move by {@code steps} steps or not
     * @param square the square that the pawn to perform the check on is standing on
     * @param steps the number of steps
     * @return true if the {@code pawn} pawn can move by {@code steps} steps; false otherwise
     */
    private boolean canPawnOnSquareMoveBy(Square square, int steps){
        return false;
    }

    /**
     * Saves the game
     * <b>Postcondition</b> saves the game to a file
     */
    public void save(File file){

    }

    /**
     * Loads the game from a save file
     * <b>Precondition</b> a valid .sorry file
     * <b>Postcondition</b> loads the game from the file
     * @param file the save file
     */
    public void load(File file){

    }

    public static void main(String[] args) {
        new Controller();
    }

}
