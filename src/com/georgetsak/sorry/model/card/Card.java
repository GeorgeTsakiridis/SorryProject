package com.georgetsak.sorry.model.card;

/**
 * Contains the method signatures required for creating a Sorry! game card.
 */

public interface Card {

    /**
     * <b>Accessor</b> returns the steps a pawn has to move forwards
     * <b>Postcondition</b> card's required forward steps have been returned
     * @return the forward steps a pawn has to move
     */
    int getForwardSteps();

    /**
     * <b>Accessor</b> returns the steps a pawn has to move backwards
     * <b>Postcondition</b> card's required backward steps have been returned
     * @return the backward steps a pawn has to move
     */
    int getBackwardSteps();

    /**
     * <b>Accessor</b> returns whether or not a player can exit a pawn from the start zone
     * <b>Postcondition</b> whether or not a player can exit a pawn from the start zone has been returned
     * @return whether or not a player can exit a pawn from the start zone
     */
    boolean canAddPawn();

    /**
     * <b>Accessor</b> returns whether or not the card is a Sorry card
     * <b>Postcondition</b> whether or not the card is a Sorry card has been returned
     * @return whether or not the card is a Sorry card
     */
    boolean isSorry();

    /**
     * <b>Accessor</b> returns whether or not the steps on the card can be split between two pawns
     * <b>Postcondition</b> whether or not the steps on the card can be split between two pawns has been returned
     * @return whether or not the steps on the card can be split between two pawns
     */
    boolean isSplit();

    /**
     * <b>Accessor</b> returns whether or not the player must draw another card
     * <b>Postcondition</b> whether or not the player must draw another card has been returned
     * @return whether or not the player must draw another card
     */
    boolean drawAgain();

    /**
     * <b>Accessor</b> returns whether or not the card is an Eleven card
     * <b>Postcondition</b> whether or not the card is an Eleven card has been returned
     * @return whether or not the card is an Eleven card
     */
    boolean isEleven();

    /**
     * Creates and returns a new card that matches the given string or null if the string does not match with a card
     * <b>Precondition</b> A valid string
     * <b>Postcondition</b> A new card is created and returned that matches the given string
     * @param s the input string
     * @return A new card that matches the given string; null if no card matches with the string
     */
    static Card toCard(String s){
        switch (s){
            case "1": return new CardOne();
            case "2": return new CardTwo();
            case "3": return new CardThree();
            case "4": return new CardFour();
            case "5": return new CardFive();
            case "7": return new CardSeven();
            case "8": return new CardEight();
            case "10": return new CardTen();
            case "11": return new CardEleven();
            case "12": return new CardTwelve();
            case "S": return new CardSorry();
            default: return null;
        }
    }


}
