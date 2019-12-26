package com.georgetsak.sorry.model;

import java.util.ArrayList;

/**
 * This class represents a player
 */
public class Player {

    private final Color color;
    private ArrayList<Pawn> pawns = new ArrayList<>();

    /**
     * <b>Constructor</b> constructs a player with {@code color} color
     * <b>Precondition</b> {@code color} is not empty and is not {@link Color#NONE}
     * <b>Postcondition</b> a player with {@code color} color is created
     * @param color the color of the player
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * <b>Accessor</b> returns the color of the player
     * <b>Postcondition</b> the color of the player is returned
     * @return the color of the player
     */
    public Color getColor() {
        return color;
    }

    /**
     * <b>Transformer(mutative)</b> adds a pawn to the player
     * <b>Precondition</b> the pawn is not null and its color is the same with the player
     * <b>Postcondition</b> the pawn is added to the player
     * @param pawn the pawn to be added to the player
     */
    public void addPawn(Pawn pawn){
        pawns.add(pawn);
    }

    /**
     * <b>Accessor</b> returns all the pawns of the player
     * <b>Postcondition</b> all the pawns of the player are returned
     * @return an {@link ArrayList} of the pawns of the player
     */
    public ArrayList<Pawn> getPawns(){
        return pawns;
    }

    /**
     * <b>Accessor</b> returns the id of the {@code} pawn. The first pawn has an id of 0 while the second an id of 1.
     * -1 is returned if the player hasn't that pawn.
     * <b>Postcondition</b> The id of the pawn is returned if it is owned by the player. -1 otherwise
     * @param pawn the pawn to get the id of
     * @return The id of the pawn
     */
    public int getPawnId(Pawn pawn){
        if(pawn == pawns.get(0))return 0;
        if(pawn == pawns.get(1))return 1;

        return -1;
    }

}
