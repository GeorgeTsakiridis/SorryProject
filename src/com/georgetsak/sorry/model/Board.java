package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.square.*;

import java.util.ArrayList;

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
        commonSquares = new Square[60];
        homeSquares = new Square[2];
        safetySquares = new Square[12];
        newBoard();
    }

    /**
     * <b>Transformer(mutative)<b/> resets the board's squares
     * <b>Postcondition</b> resets the board's squares
     */
    public void newBoard(){
        for(int i = 0; i <= 59; i++) {
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

        homeSquares[0] = new SquareStart(60, Color.RED);
        homeSquares[1] = new SquareStart(67, Color.YELLOW);

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
        else if(squareID <= 73)return safetySquares[squareID-62];
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

    /**
     * <b>Accessor</b> Returns the exit square for the player with {@code color} color.
     * <b>Preconditions</b> {@code color} is {@link Color#RED} or {@link Color#YELLOW};
     * <b>Postconditions</b> the exit square is returned
     * @param color
     * @return the exit square of the player with {@code color} color.
     */
    public Square getExitForColor(Color color){
        if(color == Color.RED)return commonSquares[15];
        if(color == Color.YELLOW)return commonSquares[45];
        return null;
    }

    /**
     * <b>Accessor</b> Gets the next square of {@code square} following the {@code color} rules.
     * This recursive method executes {@code steps} times.
     * <b>Preconditions</b> steps is a non-negative integer and {@code color} is {@link Color#RED} or {@link Color#YELLOW}
     * <b>Postcondition</b> The next square of {@code square} is returned
     * @param square the start square
     * @param color used for determining the appropriate next square.
     * @param steps the times the method should execute
     * @return The next square of {@code square}
     */
    public Square getNextSquare(Color color, Square square, int steps){
        if(square == null)return null;
        if(steps == 0)return square;

        int id = square.getId();

        Square nextSquare = null;

        if(isSafetyEntranceForColor(square, color)){//check entry
            if(color == Color.RED){
                nextSquare = getSquare(61);
            } else if(color == Color.YELLOW){
                nextSquare = getSquare(68);
            }
        }else if(id == 59){
            nextSquare = getSquare(0);
        }
        else if(id == 66 || id == 73 || id == 60 || id == 67){
            nextSquare = null;
        }else{
            nextSquare = getSquare(id + 1);
        }

        return getNextSquare(color, nextSquare, steps-1);
    }

    /**
     * <b>Accessor</b> Gets the previous square of {@code square}. This recursive method executes {@code steps} times.
     * <b>Preconditions</b> steps is a non-negative integer
     * <b>Postcondition</b> The previous square of {@code square} is returned
     * @param square
     * @param steps
     * @return The previous square of {@code square}
     */
    public Square getPrevSquare(Square square, int steps){
        if(square == null)return null;
        if(steps == 0)return square;

        int id = square.getId();

        Square prevSquare;
        if(id == 61){
            prevSquare = getSquare(13);
        }else if(id == 68){
            prevSquare = getSquare(43);
        }else if(id == 0){
            prevSquare = getSquare(59);
        }else if(id == 60 || id == 67 || id == 66 || id == 73){
            prevSquare = null;
        }
        else{
            prevSquare = getSquare(id - 1);
        }

        return getPrevSquare(prevSquare, steps-1);
    }

    /**
     * <b>Accessor</b> Returns the square that hosts the {@code pawn} pawn. If no such square exists null is returned.
     * <b>Postcondition</b> the square that hosts the {@code pawn} pawn is returned. If no such square exists null is returned.
     * @param pawn
     * @return the square that hosts the {@code pawn} pawn. 'null' if such square is not found
     */
    public Square getSquareOfPawn(Pawn pawn){
        if(pawn == null)return null;

        for(Square square : commonSquares){
            if(square.getPawnOnTop() == pawn)return square;
        }

        for(Square square : safetySquares){
            if(square.getPawnOnTop() == pawn)return square;
        }

        ArrayList<Pawn> startList1 = ((SquareMultiplePawns)homeSquares[0]).getPawnsOnTop();
        ArrayList<Pawn> startList2 = ((SquareMultiplePawns)homeSquares[1]).getPawnsOnTop();
        ArrayList<Pawn> startList3 = ((SquareMultiplePawns)safetySquares[5]).getPawnsOnTop();
        ArrayList<Pawn> startList4 = ((SquareMultiplePawns)safetySquares[11]).getPawnsOnTop();

        if(startList1.size() > 0 && startList1.get(0) == pawn)return homeSquares[0];
        if(startList1.size() > 1 && startList1.get(1) == pawn)return homeSquares[0];
        if(startList2.size() > 0 && startList2.get(0) == pawn)return homeSquares[1];
        if(startList2.size() > 1 && startList2.get(1) == pawn)return homeSquares[1];

        if(startList3.size() > 0 && startList3.get(0) == pawn)return safetySquares[5];
        if(startList3.size() > 1 && startList3.get(1) == pawn)return safetySquares[5];
        if(startList4.size() > 0 && startList4.get(0) == pawn)return safetySquares[11];
        if(startList4.size() > 1 && startList4.get(1) == pawn)return safetySquares[11];

        return null;
    }

}
