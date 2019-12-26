package com.georgetsak.sorry.model.card;

/**
 * This class represents an One card
 */
public class CardOne extends CardDirectional{
    public CardOne() {
        super(1);
    }

    @Override
    public boolean canAddPawn() {
        return true;
    }

    @Override
    public String toString() {
        return "1";
    }
}
