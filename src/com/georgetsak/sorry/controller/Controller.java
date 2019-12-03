package com.georgetsak.sorry.controller;

import com.georgetsak.sorry.model.Player;
import com.georgetsak.sorry.model.board.Board;
import com.georgetsak.sorry.model.board.squares.Square;
import com.georgetsak.sorry.model.card.Card;
import com.georgetsak.sorry.model.card.Deck;

public class Controller {

    private Player playerRed;
    private Player playerYellow;
    private Player playerPlaying = null;

    private Board board;
    private Deck deck;
    private Square[] commonSquares;
    private Card currentCard;

    public Controller(){

    }

    private void initGame(){

    }

    private void nextTurn(){

    }

    public boolean canPlayerFold(){
        return false;
    }

    public boolean canPlayerPickCard(){
        return false;
    }

    public void movePawnOnSquareTo(Square origin, Square destination){

    }

    public void pickCard(){

    }



}
