package com.georgetsak.sorry.model.card;

/**
 * This class represents a Two card
 */
public class CardTwo extends CardDirectional{
    public CardTwo() {
        super(2);
    }

    @Override
    public boolean canAddPawn() {
        return true;
    }

    @Override
    public boolean drawAgain() {
        return true;
    }

    @Override
    public String toString() {
        return "2";
    }
}
