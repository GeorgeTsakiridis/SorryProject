package com.georgetsak.sorry.model.square;

import com.georgetsak.sorry.model.Color;

/**
 * This class represents the first square of a slider
 */
public class SquareSlideEntrance extends Square{

    private final int length;

    /**
     * <b>Constructor</b> Constructs a new SquareSlideEntrance with {@code id} id, {@code color} color and {@code length} length
     * <b>Precondition</b> id is unique and not negative, Color is not null or {@link Color#NONE} and length is a positive integer
     * <b>Postcondition</b>  a new SquareSlideEntrance with {@code id} id, {@code color} color and {@code length} length is created
     * @param id the id of the square
     * @param color the color of the square
     * @param length the length of the slider
     */
    public SquareSlideEntrance(int id, Color color, int length){
        super(id, color);
        this.length = length;
    }

    /**
     * <b>Accessor</b> returns the length of the slider
     * <b>Postcondition</b> the length of the slider is returned
     * @return the length of the slider
     */
    public int getLength() {
        return length;
    }

}
