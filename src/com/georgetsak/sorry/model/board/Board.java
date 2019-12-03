package com.georgetsak.sorry.model.board;

import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.board.squares.Square;
import com.georgetsak.sorry.model.board.squares.SquareMultiplePawns;

import java.util.ArrayList;

/**
 * This class represents a board and contains methods for changing pawns position and checking if moves are valid
 */
public class Board {

    private Square[] commonSquares;
    private Square[] homeSquares;
    private Square[] safetySquares;

    /**
     * <b>Constructor</b> constructs a new Board
     * <b>Postcondition</b> creates a new board and initializes the squares of the board
     */
    public Board(){

    }

    /**
     * <b>Transformer(mutative)<b/> resets the board's squares
     * <b>Postcondition</b> resets the board's squares
     */
    public void newBoard(){

    }

    /**
     * <b>Observer</b> returns true or false depending on whether or not the square is a slider start
     * <b>Precondition</b> a non null square
     * <b>Postcondition<b/> returns true or false depending on whether or not the square is a slider start
     * @param square the square to perform the check on
     * @return true if {@code square} is a slider start or false otherwise
     */
    public boolean isSlider(Square square){
        return false;
    }

    /**
     * <b>Observer</b> returns true or false depending on whether or not the {@code square} square is a safety zone entrance with a {@code color} color
     * <b>Precondition</b> a non null square
     * <b>Postcondition<b/> returns true or false depending on whether or not the square is a safety zone entrance with a {@code color} color
     * @param square the square to perform the check on
     * @param color the required color of the safety zone entrance
     * @return true if {@code square} is a safety zone entrance with {@code color} color or false otherwise
     */
    public boolean isSafetyEntranceForColor(Square square, Color color){
        return false;
    }

    /**
     * <b>Accessor</b> returns the pawn that is on top of the square with {@code squareID} id or null if the square has not a pawn on top of it
     * <b>Precondition</b> a valid square id that is not a sub-class of {@link SquareMultiplePawns}
     * <b>Postcondition</b> returns the pawn that is on top of the given square with a matching id or null if the square has not a pawn on top of it
     * @param squareID the square ID to perform the check on
     * @return the pawn on top of the square with a matching id; null if the square has not a pawn on top of it
     */
    public Pawn getPawnOnTop(int squareID){
        return null;
    }

    /**
     * <b>Accessor</b> returns the pawns that are on top of the square with {@code squareID} id
     * <b>Precondition</b> a valid square id that is a sub-class of {@link SquareMultiplePawns}
     * <b>Postcondition</b> returns the pawns that are on top of the given square with a matching id
     * @param squareID the square ID to perform the check on
     * @return {@link ArrayList} with the pawns that are on top of the square with a matching id; empty {@link ArrayList} if the square has not a pawn on top of it
     */
    public ArrayList<Pawn> getPawnsOnTop(int squareID){
        return null;
    }

    /**
     * <b>Observer</b> checks if the {@code pawn} pawn can move by {@code steps} steps
     * <b>Precondition</b> a non null {@code pawn} and a non 0 {@code steps}
     * <b>Postcondition</b> returns true depending on whether or not the given pawn can move by {@code steps} steps or not
     * @param pawn the pawn to perform the check on
     * @param steps the number of steps
     * @return true if the {@code pawn} pawn can move by {@code steps} steps; false otherwise
     */
    public boolean canPawnMoveForwardBy(Pawn pawn, int steps){
        return false;
    }

}
