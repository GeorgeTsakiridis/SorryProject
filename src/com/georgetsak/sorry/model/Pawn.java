package com.georgetsak.sorry.model;

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

    /**
     * <b>Accessor</b> Returns the color of the pawn
     * <b>Postcondition</b> the color of the pawn is returned
     * @return the color of the pawn
     */
    public Color getColor() {
        return color;
    }
}
