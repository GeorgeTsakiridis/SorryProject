package com.georgetsak.sorry.model.square;

import com.georgetsak.sorry.model.Board;
import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.Pawn;

/**
 * This class represents a square and provides some modification methods
 */
public abstract class Square {

    private Pawn pawn;
    private final int id;
    private final Color color;

    /**
     * <b>Constructor</b> Creates a new square with {@code id} id and {@code color} color
     * <b>Precondition<b/> {@code id} is unique and {@code color} is not null
     * <b>Postcondition</b> a square with with {@code id} id and {@code color} color is created
     * @param id the unique id of the square
     * @param color the color of the square
     */
    public Square(int id, Color color){
        this.id = id;
        this.color = color;
    }

    /**
     * <b>Accessor</b> Returns the color of the square
     * <b>Postcondition</b> The color of the square has been returned
     * @return the color of the square
     */
    public Color getColor() {
        return color;
    }

    /**
     * <b>Accessor</b> Returns the pawn on top of the square
     * <b>Postcondition</b> The pawn on top of the square has been returned
     * @return the pawn on top of the square
     */
    public Pawn getPawnOnTop(){
        return pawn;
    }

    /**
     * <b>Transformer(mutative)</b> Sets the pawn that is on top of the square
     * <b>Precondition</b> No pawn is on top of the square
     * <b>Postcondition</b> The pawn is placed on top of the square
     * @param pawn The pawn to be placed on top of the square
     */
    public void setPawnOnTop(Pawn pawn){
        this.pawn = pawn;
    }

    /**
     * <b>Accessor</b> Returns the id of the square
     * <b>Postcondition</b> the id of the square is returned
     * @return the id of the square
     */
    public int getId(){return id;}

}
