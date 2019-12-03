package com.georgetsak.sorry.model.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class represents a Deck and provides modification methods
 */
public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * <b>Constructor</b> Creates a new Deck with 44 shuffled cards in it
     */
    public Deck(){
        generateNewDeck();
    }

    /**
     * <b>Accessor<b/>Returns the top card of the deck if it is no empty
     * <b>Precondition</b> The deck is not empty
     * <b>Postcondition<b/> The top card of the deck is returned or null if there was no card in deck
     * @return the top card of the deck; null otherwise
     */
    public Card pickCard(){
        return null;
    }

    /**
     *<b>Transformer(mutative)</b> Removes the given card from the deck
     * <b>Precondition<b/> The card must be in the deck
     * <b>Postcondition<b/> The card has been removed from the deck
     * @param card the card to be removed
     */
    public void removeCard(Card card){

    }

    /**
     * <b>Observer</b> Returns whether or not the deck is empty
     * <b>Postcondition</b> Whether or not deck is empty has been returned
     * @return whether or not the deck is empty
     */
    public boolean isDeckEmpty(){
        return cards.size() == 0;
    }

    /**
     * <b>Accessor</b> Returns the number of cards that are in the deck
     * <b>Postcondition</b> The number of cards in deck has been returned
     * @return the number of cards that are in the deck
     */
    public int getAvailableCards(){
        return cards.size();
    }

    /**
     * <b>Transformer(mutative)</b> Generates a new deck and shuffles the cards
     * <b>Postcondition</b> A new and shuffled deck has been generated
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
