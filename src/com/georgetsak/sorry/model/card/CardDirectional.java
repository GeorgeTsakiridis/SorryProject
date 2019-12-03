package com.georgetsak.sorry.model.card;

/**
 * This class represents a Directional card
 */
public class CardDirectional extends CardMove {

    int steps;

    /**
     * <b>Constructor<b/> creates a new Direction card with <code>steps</code> steps.
     * @param steps the steps a pawn must move
     */
    public CardDirectional(int steps){
        this.steps = steps;
    }

    @Override
    public int getForwardSteps() {
        if(steps > 0)return steps;

        return 0;
    }

    @Override
    public int getBackwardSteps() {
        if(steps < 0)return -steps;

        return 0;
    }

}
