package com.georgetsak.sorry.model.card;

/**
 * This class represents a Seven card
 */
public class CardSeven extends CardMove{

    @Override
    public int getForwardSteps() {
        return 7;
    }

    @Override
    public int getBackwardSteps() {
        return 0;
    }

    @Override
    public boolean isSplit() {
        return true;
    }

    @Override
    public String toString() {
        return "7";
    }
}
