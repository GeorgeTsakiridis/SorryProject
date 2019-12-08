package com.georgetsak.sorry.model.square;

import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.Pawn;

import java.util.ArrayList;

public class SquareMultiplePawns extends Square {

    ArrayList<Pawn> pawns = new ArrayList<>();

    public SquareMultiplePawns(int id, Color color) {
        super(id, color);
    }

    public ArrayList<Pawn> getPawnsOnTop() {
        return pawns;
    }

    public void addPawnOnTop(Pawn pawn){
        pawns.add(pawn);
    }

    public void removePawnFromTop(Pawn pawn){
        pawns.remove(pawn);
    }

}
