package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.board.Color;
import com.georgetsak.sorry.model.board.Square;

public class Pawn {

    private final Color color;
    private Square position;

    public Pawn(Color color, Square startPosition) {
        this.color = color;
        position = startPosition;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public Square getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }
}
