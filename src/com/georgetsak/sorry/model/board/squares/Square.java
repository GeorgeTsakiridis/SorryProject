package com.georgetsak.sorry.model.board.squares;

import com.georgetsak.sorry.model.Pawn;
import com.georgetsak.sorry.model.board.Color;

public abstract class Square {

    private Pawn pawn;
    private final int id;
    private final Color color;

    public Square(int id, Color color){
        this.id = id;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Pawn getPawnOnTop(){
        return pawn;
    }
    public void setPawnOnTop(Pawn pawn){
        this.pawn = pawn;
    }

    public int getId(){return id;}

}
