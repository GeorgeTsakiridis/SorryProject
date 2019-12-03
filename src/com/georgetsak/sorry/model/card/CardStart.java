package com.georgetsak.sorry.model.card;

/**
 * This class represents a Start card
 */
public class CardStart extends CardDirectional{

    private boolean drawAgain;

    /**
     * <b>Constructor</b> Constructs a new Start Card that can or cannot draw again depending on {@code drawAgain} with {@code steps} steps
     * @param steps the steps a pawn must move
     * @param drawAgain whether or not the player must draw another card again.
     */
    public CardStart(int steps, boolean drawAgain) {
        super(steps);
        this.drawAgain = drawAgain;
    }

    @Override
    public boolean canAddPawn() {
        return true;
    }

    @Override
    public boolean drawAgain() {
        return drawAgain;
    }
}
