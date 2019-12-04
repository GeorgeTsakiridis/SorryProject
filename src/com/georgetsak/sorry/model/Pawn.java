package com.georgetsak.sorry.model;

import com.georgetsak.sorry.model.board.Color;

/**
 * This class represents a Pawn
 */
public class Pawn {

    private final Color color;

    /**
     * <b>Constructor</b> constructs a new Pawn with {@code color} color
     * <b>Precondition</b>{@code color} is not null and is not {@link Color#NONE}
     * <b>Postcondition</b> creates a new Pawn with the provided color.
     * @param color the color of the pawn
     */
    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
