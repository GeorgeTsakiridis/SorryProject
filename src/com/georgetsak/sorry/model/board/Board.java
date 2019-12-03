package com.georgetsak.sorry.model.board;

import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.board.squares.Square;
import com.georgetsak.sorry.model.board.squares.SquareMultiplePawns;

import java.util.ArrayList;

public class Board {

    private Square[] commonSquares;
    private Square[] homeSquares;
    private Square[] safetySquares;

    public Board(){

    }

    public void newBoard(ArrayList<Pawn> playerRedPawns, ArrayList<Pawn> playerYellowPawns){

    }

    public boolean isSlider(Square square){
        return false;
    }

    public boolean isSafetyEntranceForColor(Color color){
        return false;
    }

    public void setPawnOnTop(Square square, Pawn pawn){

    }

    public Pawn getPawnOnTop(Square square){
        return null;
    }

    public ArrayList<Pawn> getPawnsOnTop(SquareMultiplePawns square){
        return null;
    }

    public boolean canPawnMoveForwardBy(Pawn pawn, int steps){
        return false;
    }

}
