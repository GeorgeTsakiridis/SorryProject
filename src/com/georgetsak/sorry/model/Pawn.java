package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.board.Color;
import com.georgetsak.sorry.model.board.squares.Square;

/**
 * This class represents a Pawn
 */
public class Pawn {

    private final Color color;
    private Square position;

    /**
     * <b>Constructor</b> constructs a new Pawn with {@code color} color with {@code startPosition} start position
     * <b>Precondition</b>{@code color} and {@code startPosition} are not null and {@code color} is not {@link Color#NONE}
     * <b>Postcondition</b> creates a new Pawn with the provided color positioned at the {@code startPosition} square.
     * @param color the color of the pawn
     * @param startPosition the starting square of the pawn
     */
    public Pawn(Color color, Square startPosition) {
        this.color = color;
        position = startPosition;
    }

    /**
     * <b>Transformer(mutative)</b> sets the square the pawn is positioned at
     * <b>Precondition</b> {@code position} is a valid Square
     * <b>Postcondition</b> the new position of the pawn is the provided one
     * @param position the new position of the pawn
     */
    public void setPosition(Square position) {
        this.position = position;
    }

    /**
     * <b>Accessor</b> returns the square the pawn is at
     * <b>Postcondition</b> the square the pawn is at is returned
     * @return the square the pawn is at
     */
    public Square getPosition() {
        return position;
    }

    /**
     * <b>Accessor</b> returns the color of the pawn
     * <b>Postcondition</b> the color of the pawn is returned
     * @return the color of the pawn
     */
    public Color getColor() {
        return color;
    }
}
