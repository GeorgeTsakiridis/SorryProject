package com.georgetsak.sorry.model.card;

/**
 * Contains the method signatures required for creating a Sorry! game card.
 */

public interface Card {

    /**
     * <b>Accessor:</b> returns the steps a pawn has to move forwards
     * <b>Postcondition:</b> card's required forward steps have been returned
     * @return the forward steps a pawn has to move
     */
    int getForwardSteps();

    /**
     * <b>Accessor:</b> returns the steps a pawn has to move backwards
     * <b>Postcondition:</b> card's required backward steps have been returned
     * @return the backward steps a pawn has to move
     */
    int getBackwardSteps();

    /**
     * <b>Accessor:</b> returns whether or not a player can exit a pawn from the start zone
     * <b>Postcondition:</b> whether or not a player can exit a pawn from the start zone has been returned
     * @return whether or not a player can exit a pawn from the start zone
     */
    boolean canAddPawn();

    /**
     * <b>Accessor:</b> returns whether or not the card is a Sorry card
     * <b>Postcondition:</b> whether or not the card is a Sorry card has been returned
     * @return whether or not the card is a Sorry card
     */
    boolean isSorry();

    /**
     * <b>Accessor:</b> returns whether or not the steps on the card can be split between two pawns
     * <b>Postcondition:</b> whether or not the steps on the card can be split between two pawns has been returned
     * @return whether or not the steps on the card can be split between two pawns
     */
    boolean isSplit();

    /**
     * <b>Accessor:</b> returns whether or not the player must draw another card
     * <b>Postcondition:</b> whether or not the player must draw another card has been returned
     * @return whether or not the player must draw another card
     */
    boolean drawAgain();

    /**
     * <b>Accessor:</b> returns whether or not the card is an Eleven card
     * <b>Postcondition:</b> whether or not the card is an Eleven card has been returned
     * @return whether or not the card is an Eleven card
     */
    boolean isEleven();
}
