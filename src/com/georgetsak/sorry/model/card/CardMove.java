package com.georgetsak.sorry.model.card;

/**
 * This class represents a card that requires a pawn to be moved
 */
public abstract class CardMove implements Card{

    @Override
    public boolean canAddPawn() {
        return false;
    }

    @Override
    public boolean isSorry() {
        return false;
    }

    @Override
    public boolean isEleven() {
        return false;
    }

    @Override
    public boolean isSplit() {
        return false;
    }

    @Override
    public boolean drawAgain(){ return false;}

}
