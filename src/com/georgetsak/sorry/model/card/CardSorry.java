package com.georgetsak.sorry.model.card;

/**
 * This class represents a Sorry card
 */
public class CardSorry implements Card {

    @Override
    public int getForwardSteps() {
        return 0;
    }

    @Override
    public int getBackwardSteps() {
        return 0;
    }

    @Override
    public boolean canAddPawn() {
        return false;
    }

    @Override
    public boolean isSorry() {
        return true;
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
    public boolean drawAgain() {
        return false;
    }

    @Override
    public String toString() {
        return "S";
    }
}
