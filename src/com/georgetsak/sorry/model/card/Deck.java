package com.georgetsak.sorry.model.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class represents a Deck and provides modification methods
 */
public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * <b>Constructor</b>
     */
    public Deck(){

    }

    public Card pickCard(){
        return null;
    }

    public boolean isDeckEmpty(){
        return cards.size() == 0;
    }

    public int getAvailableCards(){
        return cards.size();
    }

    public void generateNewDeck(){
        for(int i = 0; i < 4; i++){
            cards.add(new CardOne());
            cards.add(new CardTwo());
            cards.add(new CardThree());
            cards.add(new CardFour());
            cards.add(new CardFive());
            cards.add(new CardSeven());
            cards.add(new CardEight());
            cards.add(new CardTen());
            cards.add(new CardEleven());
            cards.add(new CardTwelve());
            cards.add(new CardSorry());
        }

        Collections.shuffle(cards);
    }

}
