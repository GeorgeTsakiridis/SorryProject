package com.georgetsak.sorry.model.card;

/**
 * This class represents an Eleven card
 */
public class CardEleven extends CardDirectional{

    public CardEleven() {
        super(11);
    }

    @Override
    public boolean isEleven() {
        return true;
    }

}
