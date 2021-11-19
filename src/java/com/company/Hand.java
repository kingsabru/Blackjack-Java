package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int numOfCards;


    public Hand(){
        cards = new ArrayList<>(10);
        numOfCards = 0;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public List<Card> getCards(){
        return cards;
    }

    public int getTotal() {
        return cards.stream().mapToInt(Card::getValue).sum();
    }
}
