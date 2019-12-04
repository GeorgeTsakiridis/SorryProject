package com.georgetsak.sorry.model.board;

import com.georgetsak.sorry.model.board.squares.Square;

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
        newBoard();
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
     * <b>Accessor</b> returns the square that its id match with {@code squareID}
     * <b>Postcondition</b> returns the square that its id match with {@code squareID}; null otherwise
     * @param squareID the square ID to search with
     * @return the square with matching id or null if a square with matching id is not found
     */
    public Square getSquare(int squareID){
        return null;
    }

    /**
     * <b>Accessor</b> returns the start square of {@code color} color.
     * <b>Precondition</b> the {@code color} color is either {@link Color#RED} or {@link Color#YELLOW}
     * <b>Postcondition</b> returns the start square of {@code color} color or null if such square is not found
     * @param color the color of the wanted start square
     * @return the square with matching id or null if a square with matching id is not found
     */
    public Square getStartForColor(Color color){
        return null;
    }

}
