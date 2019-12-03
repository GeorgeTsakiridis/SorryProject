package com.georgetsak.sorry.model.board.squares;

import com.georgetsak.sorry.model.board.Color;

public class SquareSlideEntrance extends Square{

    private final int length;

    public SquareSlideEntrance(int id, Color color, int length){
        super(id, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

}
