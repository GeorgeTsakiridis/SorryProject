package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.board.Color;

import java.util.ArrayList;

public class Player {

    private final Color color;
    private ArrayList<Pawn> pawns = new ArrayList<>();

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }

    public ArrayList<Pawn> getPawns(){
        return pawns;
    }

}
