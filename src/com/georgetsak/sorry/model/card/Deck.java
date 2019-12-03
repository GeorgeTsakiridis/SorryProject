package com.georgetsak.sorry.model.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class represents a Deck and provides modification methods
 */
public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * <b>Constructor</b> constructs a new Deck with 44 shuffled cards in it
     * <b>Postcondition</b> creates a new Deck with 44 shuffled cards in it
     */
    public Deck(){
        generateNewDeck();
    }

    /**
     * <b>Accessor<b/> returns the top card of the deck if it is no empty
     * <b>Precondition</b> the deck is not empty
     * <b>Postcondition<b/> the top card of the deck is returned or null if there was no card in deck
     * @return the top card of the deck; null otherwise
     */
    public Card pickCard(){
        return null;
    }

    /**
     *<b>Transformer(mutative)</b> removes the given card from the deck
     * <b>Precondition<b/> the card must be in the deck
     * <b>Postcondition<b/> the card has been removed from the deck
     * @param card the card to be removed
     */
    public void removeCard(Card card){

    }

    /**
     * <b>Observer</b> returns whether or not the deck is empty
     * <b>Postcondition</b> whether or not deck is empty has been returned
     * @return whether or not the deck is empty
     */
    public boolean isDeckEmpty(){
        return cards.size() == 0;
    }

    /**
     * <b>Accessor</b> returns the number of cards that are in the deck
     * <b>Postcondition</b> the number of cards in deck has been returned
     * @return the number of cards that are in the deck
     */
    public int getAvailableCards(){
        return cards.size();
    }

    /**
     * <b>Transformer(mutative)</b> generates a new deck and shuffles the cards
     * <b>Postcondition</b> a new and shuffled deck has been generated
     */
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
