package com.georgetsak.sorry.controller;

import com.georgetsak.sorry.model.Board;
import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.Player;
import com.georgetsak.sorry.model.card.*;
import com.georgetsak.sorry.model.square.*;
import com.georgetsak.sorry.viewer.View;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private boolean movedPawn;

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

        pickedCard = false;
        obeyedCard = false;
        currentCard = null;
        movedPawn = false;

        view = new View(this);

        playerPlaying = new Random().nextBoolean() ? playerRed : playerYellow;

        for (int i = 0; i < 2; i++) {
            Pawn redPawn = new Pawn(Color.RED);
            Pawn yellowPawn = new Pawn(Color.YELLOW);

            playerRed.addPawn(redPawn);
            view.renderPawnOnSquare(60, redPawn, i);
            playerYellow.addPawn(yellowPawn);
            view.renderPawnOnSquare(67, yellowPawn, i);

            ((SquareMultiplePawns)board.getStartForColor(Color.RED)).addPawnOnTop(redPawn);
            ((SquareMultiplePawns)board.getStartForColor(Color.YELLOW)).addPawnOnTop(yellowPawn);
        }

        nextTurn();
        view.updateGUI(playerPlaying.getColor(), currentCard, deck.getAvailableCards());
    }

    /**
     * <b>Transformer(mutative)<b/> changes the turn to the next player
     * <b>Postcondition<b/> the turn is given to the next player
     */
    private void nextTurn(){
        view.resetOrigin();
        currentCard = null;
        obeyedCard = false;
        pickedCard = false;
        movedPawn = false;
        playerPlaying = playerPlaying == playerRed ? playerYellow : playerRed;
    }

    /**
     * <b>Observer</b> returns true or false depending on whether or not the player can pick a card
     * <b>Postcondition</b> true is returned if the player can pick a card; false otherwise
     * @return true if the player can pick a card or false if the player cannot pick a card
     */
    public boolean canPlayerPickCard(){
        return !pickedCard;
    }

    /**
     * <b>Transformer(mutative)</b> Moves the pawn on top of {@code origin} to {@code destination} if the move is valid.
     * <b>Precondition<b/> {@code origin} and {@code destination} are not null
     * <b>Postcondition<b/> The pawn on top of {@code origin} is moved to {@code destination} if the move is valid
     * @param origin The square the pawn to move is at
     * @param destination The square the pawn is requested to move
     */
    public void movePawnOnSquareTo(int origin, int destination) {
        if (currentCard == null) return;

        Square squareOrigin = board.getSquare(origin);
        Square squareDestination = board.getSquare(destination);
        Color playingColor = playerPlaying.getColor();

        if (currentCard instanceof CardOne) {
            Square next = board.getNextSquare(playingColor, squareOrigin, currentCard.getForwardSteps());

            if (squareOrigin instanceof SquareStart && squareOrigin.getColor() == playingColor && destination == board.getExitForColor(playingColor).getId() && (squareDestination.getPawnOnTop() == null || squareDestination.getPawnOnTop() != null && squareDestination.getPawnOnTop().getColor() != playingColor)) {
                perfomPawnMove(squareOrigin, squareDestination);
                obeyedCard = true;
                movedPawn = true;
            } else if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor && next != null && next.getId() == destination && (next.getPawnOnTop() == null || next.getPawnOnTop() != null && next.getPawnOnTop().getColor() != playingColor)) {//move pawn one step forward
                perfomPawnMove(squareOrigin, squareDestination);
                obeyedCard = true;
                movedPawn = true;
            }
        } else if (!movedPawn && currentCard instanceof CardTwo) {
            Square next = board.getNextSquare(playingColor, squareOrigin, currentCard.getForwardSteps());

            if (squareOrigin instanceof SquareStart && squareOrigin.getColor() == playingColor && destination == board.getExitForColor(playingColor).getId() && (squareDestination.getPawnOnTop() == null || squareDestination.getPawnOnTop() != null && squareDestination.getPawnOnTop().getColor() != playingColor)) {
                perfomPawnMove(squareOrigin, squareDestination);
                movedPawn = true;
                pickedCard = false;
            } else if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor && next != null && next.getId() == destination && (next.getPawnOnTop() == null || next.getPawnOnTop() != null && next.getPawnOnTop().getColor() != playingColor)) {
                perfomPawnMove(squareOrigin, squareDestination);
                movedPawn = true;
                pickedCard = false;
            }
        } else if (currentCard instanceof CardThree || currentCard instanceof CardFive || currentCard instanceof CardEight || currentCard instanceof CardTwelve) {
            Square next = board.getNextSquare(playingColor, squareOrigin, currentCard.getForwardSteps());
            if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor && next != null && next.getId() == destination  && (next.getPawnOnTop() == null || next.getPawnOnTop() != null && next.getPawnOnTop().getColor() != playingColor)) {
                perfomPawnMove(squareOrigin, squareDestination);
                movedPawn = true;
                obeyedCard = true;
            }
        } else if (currentCard instanceof CardFour) {
            Square prev = board.getPrevSquare(squareOrigin, currentCard.getBackwardSteps());
            if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor && prev != null && prev.getId() == destination && (prev.getPawnOnTop() == null || prev.getPawnOnTop() != null && prev.getPawnOnTop().getColor() != playingColor)) {
                perfomPawnMove(squareOrigin, squareDestination);
                movedPawn = true;
                obeyedCard = true;
            }
        } else if (currentCard instanceof CardTen) {

            Square next = board.getNextSquare(playingColor, squareOrigin, currentCard.getForwardSteps());
            Square prev = board.getPrevSquare(squareOrigin, currentCard.getBackwardSteps());

            if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor) {
                if (prev != null && prev.getId() == destination  && (prev.getPawnOnTop() == null || prev.getPawnOnTop() != null && prev.getPawnOnTop().getColor() != playingColor)) {
                    perfomPawnMove(squareOrigin, squareDestination);
                    movedPawn = true;
                    obeyedCard = true;
                } else if (next != null && next.getId() == destination  && (next.getPawnOnTop() == null || next.getPawnOnTop() != null && next.getPawnOnTop().getColor() != playingColor)) {
                    perfomPawnMove(squareOrigin, squareDestination);
                    movedPawn = true;
                    obeyedCard = true;
                }
            }

        } else if (currentCard.isEleven()) {
            Square next = board.getNextSquare(playingColor, squareOrigin, currentCard.getForwardSteps());
            if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor) {
                if (next != null && next.getId() == destination  && (next.getPawnOnTop() == null || next.getPawnOnTop() != null && next.getPawnOnTop().getColor() != playingColor)) {
                    perfomPawnMove(squareOrigin, squareDestination);
                    movedPawn = true;
                    obeyedCard = true;
                } else if (squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor
                        && origin >= 0 && origin <= 59 && destination >= 0 && destination <= 59 && squareDestination.getPawnOnTop() != null
                        && squareDestination.getPawnOnTop().getColor() != playingColor) {
                    Pawn originPawn = squareOrigin.getPawnOnTop();
                    Pawn destinationPawn = squareDestination.getPawnOnTop();

                    squareOrigin.setPawnOnTop(destinationPawn);
                    squareDestination.setPawnOnTop(originPawn);

                    view.renderPawnOnSquare(destination, originPawn, playerPlaying.getPawnId(originPawn));
                    view.renderPawnOnSquare(origin, destinationPawn, (playerPlaying == playerRed ? playerYellow : playerRed).getPawnId(destinationPawn));
                    movedPawn = true;
                    obeyedCard = true;
                }

            }
        }else if(currentCard.isSorry()){
            SquareMultiplePawns squareStart = (SquareMultiplePawns) board.getStartForColor(playingColor);
            if(squareOrigin.getId() == squareStart.getId() && squareStart.getPawnsOnTop().size() > 0 && destination >= 0 && destination <= 59
            && squareDestination.getPawnOnTop() != null && squareDestination.getPawnOnTop().getColor() != playingColor){
                Pawn originPawn = squareStart.getPawnsOnTop().get(0);
                Pawn destinationPawn = squareDestination.getPawnOnTop();

                squareStart.removePawnFromTop(originPawn);
                squareDestination.setPawnOnTop(originPawn);
                SquareMultiplePawns squareStartOpposite = (SquareMultiplePawns)board.getStartForColor(playingColor == Color.RED ? Color.YELLOW : Color.RED);
                squareStartOpposite.addPawnOnTop(destinationPawn);

                view.renderPawnOnSquare(destination, originPawn, playerPlaying.getPawnId(originPawn));
                view.renderPawnOnSquare(squareStartOpposite.getId(), destinationPawn, (playerPlaying == playerRed ? playerYellow : playerRed).getPawnId(destinationPawn));

                movedPawn = true;
                obeyedCard = true;
            }
        }else if(currentCard.isSplit()){
            boolean canMovePawn1 = false;
            if(squareOrigin.getPawnOnTop() != null && squareOrigin.getPawnOnTop().getColor() == playingColor  && (squareDestination.getPawnOnTop() == null || squareDestination.getPawnOnTop() != null && squareDestination.getPawnOnTop().getColor() != playingColor)){

                int stepsLeft = -1;
                Square squareNext = null;

                for(int i = 1; i <= 7; i++){
                    squareNext = board.getNextSquare(playingColor, squareOrigin, i);
                    if(squareNext != null && squareDestination.getId() == squareNext.getId()){
                        stepsLeft = 7 - i;
                        break;
                    }
                }

                if(stepsLeft != -1 && squareNext != null){
                    if(stepsLeft == 0){
                        if(squareNext.getPawnOnTop() == null || squareNext.getPawnOnTop() != null && squareNext.getPawnOnTop().getColor() != playingColor){
                            perfomPawnMove(squareOrigin, squareNext);
                            movedPawn = true;
                            obeyedCard = true;
                        }
                    }else{
                        if(squareNext.getPawnOnTop() == null || squareNext.getPawnOnTop() != null && squareNext.getPawnOnTop().getColor() != playingColor){
                            canMovePawn1 = true;
                        }
                        Pawn otherPawn = playerPlaying.getPawns().get(1 - playerPlaying.getPawnId(squareOrigin.getPawnOnTop()));
                        Square squareStartOtherPawn = board.getSquareOfPawn(otherPawn);
                        if(squareStartOtherPawn != null) {
                            Square next2 = board.getNextSquare(playingColor, squareStartOtherPawn, stepsLeft);
                            if(next2 != null  && (next2.getPawnOnTop() == null || next2.getPawnOnTop() != null && next2.getPawnOnTop().getColor() != playingColor)){
                                if(canMovePawn1){
                                    perfomPawnMove(squareOrigin, squareNext);
                                    perfomPawnMove(squareStartOtherPawn, next2);
                                    movedPawn = true;
                                    obeyedCard = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        ArrayList<Pawn> allPawns = new ArrayList<>();
        allPawns.add(playerRed.getPawns().get(0));
        allPawns.add(playerRed.getPawns().get(1));
        allPawns.add(playerYellow.getPawns().get(0));
        allPawns.add(playerYellow.getPawns().get(1));

        for(Pawn pawn : allPawns){
            Square fpos = board.getSquareOfPawn(pawn);
            if(board.isSlider(fpos) && fpos.getColor() != playingColor){
                SquareSlideEntrance squareSlideEntrance = (SquareSlideEntrance)fpos;
                for(int i = 0; i < squareSlideEntrance.getLength(); i++){
                    Square square = board.getNextSquare(playingColor, fpos, i+1);
                    Pawn pawn2 = square.getPawnOnTop();
                    if(pawn2 != null && square.getId() != 73 && square.getId() != 66){
                        perfomPawnMove(square, board.getStartForColor(pawn2.getColor()));
                        view.renderPawnOnSquare(board.getStartForColor(pawn2.getColor()).getId(), pawn2, pawn2.getColor() == Color.RED ? playerRed.getPawnId(pawn2) : playerYellow.getPawnId(pawn2));
                    }
                }
                perfomPawnMove(fpos, board.getNextSquare(playingColor, squareSlideEntrance, squareSlideEntrance.getLength()));
            }
        }


        if (obeyedCard) {
            nextTurn();
        }

        view.updateGUI(playerPlaying.getColor(), currentCard, deck.getAvailableCards());

        if(board.getSquareOfPawn(playerRed.getPawns().get(0)) instanceof SquareHome && board.getSquareOfPawn(playerRed.getPawns().get(1)) instanceof SquareHome){
            JOptionPane.showMessageDialog(null, "Red player won!", "Game Over!", JOptionPane.PLAIN_MESSAGE);
            view.destroy();
            new Controller();
        }
        if(board.getSquareOfPawn(playerYellow.getPawns().get(0)) instanceof SquareHome && board.getSquareOfPawn(playerYellow.getPawns().get(1)) instanceof SquareHome){
            JOptionPane.showMessageDialog(null, "Yellow player won!", "Game Over!", JOptionPane.PLAIN_MESSAGE);
            view.destroy();
            new Controller();
        }

    }

    /**
     * Moves the pawn on top of the origin square to the destination square and updates the GUI
     * <b>Precondition</b> origin square is not null and has a pawn on top of it and destination square is not null
     * <b>Postcondition</b> pawn on top of origin is moved to destination and GUI is updated
     * @param origin the origin square
     * @param destination the destination square
     */
    private void perfomPawnMove(Square origin, Square destination) {
        if(origin.getId() == destination.getId())return;

        if (origin instanceof SquareMultiplePawns) {//from multiple pawns square to plain square
            SquareMultiplePawns originMultiplePawns = (SquareMultiplePawns)origin;
            Pawn pawn = originMultiplePawns.getPawnsOnTop().get(0);
            originMultiplePawns.removePawnFromTop(pawn);
            if(destination.getPawnOnTop() != null){
                Pawn p = destination.getPawnOnTop();
                Square pHome = board.getStartForColor(p.getColor());
                destination.setPawnOnTop(null);
                ((SquareMultiplePawns)pHome).addPawnOnTop(p);
                view.renderPawnOnSquare(pHome.getId(), p, p.getColor() == Color.RED ? playerRed.getPawnId(p) : playerYellow.getPawnId(p));
            }
            destination.setPawnOnTop(pawn);
            view.renderPawnOnSquare(destination.getId(), pawn, playerPlaying.getPawnId(pawn));
        }else if(destination instanceof SquareMultiplePawns){//from plain square to multiple pawns square
            Pawn pawn = origin.getPawnOnTop();
            origin.setPawnOnTop(null);
            ((SquareMultiplePawns)destination).addPawnOnTop(pawn);
            view.renderPawnOnSquare(destination.getId(), pawn, playerPlaying.getPawnId(pawn));
        }else{//from plain square to plain square
            Pawn pawn = origin.getPawnOnTop();
            origin.setPawnOnTop(null);
            if(destination.getPawnOnTop() != null){
                Pawn p = destination.getPawnOnTop();
                Square pHome = board.getStartForColor(p.getColor());
                destination.setPawnOnTop(null);
                ((SquareMultiplePawns)pHome).addPawnOnTop(p);
                view.renderPawnOnSquare(pHome.getId(), p, p.getColor() == Color.RED ? playerRed.getPawnId(p) : playerYellow.getPawnId(p));
            }
            destination.setPawnOnTop(pawn);
            view.renderPawnOnSquare(destination.getId(), pawn, playerPlaying.getPawnId(pawn));
        }
    }

    /**
     * <b>Transformer(mutative)</b> Picks a card from the deck for the player currently playing. If deck has no cards a new deck is generated
     * <b>Postcondition<b/> a new card is picked for the currently playing player
     */
    public void pickCard(){
        if(deck.getAvailableCards() == 0)deck.generateNewDeck();

        currentCard = deck.pickCard();
        pickedCard = true;
        movedPawn = false;

        view.updateGUI(playerPlaying.getColor(), currentCard, deck.getAvailableCards());
    }

    /**
     * <b>Transformer(mutative)<b/>Forfeits the current player's move and updates the GUI
     * <b>Postcondition</b> the current player's move is forfeited and the GUI is updated
     */
    public void fold(){
        nextTurn();
        view.updateGUI(playerPlaying.getColor(), currentCard, deck.getAvailableCards());
    }

    /**
     * Saves the game into the file provided. If the file does not exist it is created
     * <b>Precondition</b> a valid file to save to or to create
     * <b>Postcondition</b> saves the game to a file
     */
    public void save(File file){
        try {
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();

            PrintWriter writer = new PrintWriter(file);

            Pawn p1 = playerRed.getPawns().get(0);
            Pawn p2 = playerRed.getPawns().get(1);
            Pawn p3 = playerYellow.getPawns().get(0);
            Pawn p4 = playerYellow.getPawns().get(1);

            int id1 = board.getSquareOfPawn(p1).getId();
            int id2 = board.getSquareOfPawn(p2).getId();
            int id3 = board.getSquareOfPawn(p3).getId();
            int id4 = board.getSquareOfPawn(p4).getId();

            writer.println(pickedCard);
            writer.println(obeyedCard);
            writer.println(movedPawn);
            if(currentCard != null) {
                writer.println(currentCard.toString());
            }else{
                writer.println("0");
            }
            writer.println(playerPlaying.getColor().name());
            writer.println(id1);
            writer.println(id2);
            writer.println(id3);
            writer.println(id4);

            for(Card c : deck.getCards()){
                writer.println(c.toString());
            }

            writer.close();


        } catch (Exception e) {
            System.err.println("Saving failed...");
            e.printStackTrace();
        }
    }

    /**
     * <b>Transformer(mutative)<b/>Loads the game from a save file
     * <b>Precondition</b> a valid .sorry file
     * <b>Postcondition</b> loads the game from the file
     * @param file a valid .sorry save file
     */
    public void load(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            pickedCard = Boolean.parseBoolean(reader.readLine());
            obeyedCard = Boolean.parseBoolean(reader.readLine());
            movedPawn = Boolean.parseBoolean(reader.readLine());
            currentCard = Card.toCard(reader.readLine());
            playerPlaying = Color.valueOf(reader.readLine()) == Color.RED ? playerRed : playerYellow;

            Pawn p1 = playerRed.getPawns().get(0);
            Pawn p2 = playerRed.getPawns().get(1);
            Pawn p3 = playerYellow.getPawns().get(0);
            Pawn p4 = playerYellow.getPawns().get(1);

            int id1 = Integer.parseInt(reader.readLine());
            int id2 = Integer.parseInt(reader.readLine());
            int id3 = Integer.parseInt(reader.readLine());
            int id4 = Integer.parseInt(reader.readLine());

            Square s1 = board.getSquare(id1);
            Square s2 = board.getSquare(id2);
            Square s3 = board.getSquare(id3);
            Square s4 = board.getSquare(id4);

            perfomPawnMove(board.getSquareOfPawn(p1), s1);
            perfomPawnMove(board.getSquareOfPawn(p2), s2);
            perfomPawnMove(board.getSquareOfPawn(p3), s3);
            perfomPawnMove(board.getSquareOfPawn(p4), s4);

            view.renderPawnOnSquare(s1.getId(), p1, 0);
            view.renderPawnOnSquare(s2.getId(), p2, 1);
            view.renderPawnOnSquare(s3.getId(), p3, 0);
            view.renderPawnOnSquare(s4.getId(), p4, 1);

            ArrayList<Card> cards = new ArrayList<>();

            while(reader.ready()){
                cards.add(Card.toCard(reader.readLine()));
            }

            deck.setCards(cards);

            view.updateGUI(playerPlaying.getColor(), currentCard, deck.getAvailableCards());

        } catch (Exception e) {
            System.err.println("Loading failed...");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Controller();
    }

}
