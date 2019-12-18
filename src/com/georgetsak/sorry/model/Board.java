package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.square.*;

/**
 * This class represents a board and contains methods for changing pawns position and some other help methods regarding squares
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
        commonSquares = new Square[59];
        homeSquares = new Square[2];
        safetySquares = new Square[12];
        newBoard();
    }

    /**
     * <b>Transformer(mutative)<b/> resets the board's squares
     * <b>Postcondition</b> resets the board's squares
     */
    public void newBoard(){
        for(int i = 0; i < 59; i++) {
            if (i != 5 && i != 12 && i != 20 && i != 27 && i != 35 && i != 42
                    && i != 50 && i != 57 && i != 13 && i != 43) {
                commonSquares[i] = new SquarePlain(i);
            }
        }

        commonSquares[5] = new SquareSlideEntrance(5, Color.GREEN, 4);
        commonSquares[12] = new SquareSlideEntrance(12, Color.RED, 3);
        commonSquares[20] = new SquareSlideEntrance(20, Color.RED, 4);
        commonSquares[27] = new SquareSlideEntrance(27, Color.BLUE, 3);
        commonSquares[35] = new SquareSlideEntrance(35, Color.BLUE, 4);
        commonSquares[42] = new SquareSlideEntrance(42, Color.YELLOW, 3);
        commonSquares[50] = new SquareSlideEntrance(50, Color.YELLOW, 4);
        commonSquares[57] = new SquareSlideEntrance(57, Color.GREEN, 3);
        commonSquares[13] = new SquareSafetyEntrance(13, Color.RED);
        commonSquares[43] = new SquareSafetyEntrance(43, Color.YELLOW);

        homeSquares[0] = new SquareHome(60, Color.RED);
        homeSquares[1] = new SquareHome(67, Color.YELLOW);

        for(int i = 61; i <= 65; i++){
            safetySquares[i - 61] = new SquarePlain(i);
        }

        safetySquares[5] = new SquareHome(66, Color.RED);

        for(int i = 68; i <= 73; i++){
            safetySquares[i - 62] = new SquarePlain(i);
        }

        safetySquares[11] = new SquareHome(73, Color.YELLOW);
    }

    /**
     * <b>Observer</b> returns true or false depending on whether or not the square is a slider start
     * <b>Precondition</b> a non null square
     * <b>Postcondition<b/> returns true or false depending on whether or not the square is a slider start
     * @param square the square to perform the check on
     * @return true if {@code square} is a slider start or false otherwise
     */
    public boolean isSlider(Square square){
        return square instanceof SquareSlideEntrance;
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
        return square instanceof SquareSafetyEntrance && square.getColor() == color;
    }

    /**
     * <b>Accessor</b> returns the square that its id match with {@code squareID}
     * <b>Postcondition</b> returns the square that its id match with {@code squareID}; null otherwise
     * @param squareID the square ID to search with
     * @return the square with matching id or null if a square with matching id is not found
     */
    public Square getSquare(int squareID){
        if(squareID < 0)return null;

        if(squareID <= 59)return commonSquares[squareID];
        else if(squareID == 60)return homeSquares[0];
        else if(squareID == 67)return homeSquares[1];
        else if(squareID <= 66)return safetySquares[squareID-61];
        else if(squareID <= 73)return safetySquares[squareID-68];
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

        for(Square square : homeSquares){
            if(square.getColor() == color)return square;
        }

        return null;
    }

}
