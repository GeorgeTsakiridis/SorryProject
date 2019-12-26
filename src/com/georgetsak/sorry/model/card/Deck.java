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
     * <b>Accessor<b/> returns the top card of the deck if it is no empty and removes the card that was picked from the deck
     * <b>Precondition</b> the deck is not empty
     * <b>Postcondition<b/> the top card of the deck is returned if the deck has a card and then that card is removed from the deck
     * @return the top card of the deck; null otherwise
     */
    public Card pickCard(){
        Card card = cards.get(cards.size() - 1);
        cards.remove(card);
        return card;
    }

    /**
     * <b>Accessor</b> returns the card array list of the deck
     * <b>Postcondition</b> the array list of all the cards in the deck is returned
     * @return an ArrayList with all the cards in the deck
     */
    public ArrayList<Card> getCards(){
        return cards;
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

    /**
     * <b>Transformer(mutative)<b/> overrides the cards stored in private field cards with the cards given in function field {@code cards}
     * <b>Precondition<b/> cards is not null
     * <b>Postcondition</b> local field cards is replaced with the cards field of the function
     * @param cards the cards list to override the Deck cards field with.
     */
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }

}
