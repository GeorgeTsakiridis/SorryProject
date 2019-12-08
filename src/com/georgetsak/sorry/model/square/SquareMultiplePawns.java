package com.georgetsak.sorry.model.square;

import com.georgetsak.sorry.model.Color;
import com.georgetsak.sorry.model.Pawn;

import java.util.ArrayList;

/**
 * This class represents a square that holds more than one pawn and provides some additional modification methods
 */
public class SquareMultiplePawns extends Square {

    ArrayList<Pawn> pawns = new ArrayList<>();

    /**
     * <b>Constructor</b> Creates a new SquareMultiplePawns with {@code id} id and {@code color} color
     * <b>Precondition<b/> {@code id} is unique and {@code color} is not null
     * <b>Postcondition</b> a square with with {@code id} id and {@code color} color is created
     * @param id the unique id of the square
     * @param color the color of the square
     */
    public SquareMultiplePawns(int id, Color color) {
        super(id, color);
    }

    /**
     * <b>Accessor</b> Returns the list that holds the pawns that are on top of the square
     * <b>Postcondition<b/> the list that holds the pawns that are on top of the square are returned
     * @return the ArrayList that holds the pawns that re on top of the square
     */
    public ArrayList<Pawn> getPawnsOnTop() {
        return pawns;
    }

    /**
     * <b>Transformer(mutative)</b> Adds the given pawn to the list that holds the pawns that are on top of the square
     * <b>Precondition</b> the pawn is not null and is not already on top of the square
     * <b>Postcondition</b> the given pawn is added to the list that holds the pawns that are on top of the square
     * @param pawn the pawn to be added to the list that holds the pawns that are on top of the square
     */
    public void addPawnOnTop(Pawn pawn){
        pawns.add(pawn);
    }

    /**
     * <b>Transformer(mutative)</b> Removes the given pawn from the list that holds the pawns that are on top of the square
     * <b>Precondition</b> the pawn is not null and is not already on top of the square
     * <b>Postcondition</b> the given pawn is removed from the list that holds the pawns that are on top of the square
     * @param pawn the pawn to be removed from the list that holds the pawns that are on top of the square
     */
    public void removePawnFromTop(Pawn pawn){
        pawns.remove(pawn);
    }

    @Override
    public Pawn getPawnOnTop() {
        return null;
    }

    @Override
    public void setPawnOnTop(Pawn pawn) {

    }
}
