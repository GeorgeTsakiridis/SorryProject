package com.georgetsak.sorry.model.card;

/**
 * This class represents a Ten card
 */
public class CardTen extends CardMove{

    @Override
    public int getForwardSteps() {
        return 10;
    }

    @Override
    public int getBackwardSteps() {
        return 1;
    }

}
