package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int numOfCards;
    private int total;

    public Hand(){
        cards = new ArrayList<>(10);
        numOfCards = 0;
        total = 0;
    }

    public void addCard(Card card){
        cards.add(card);
        incrementTotal(card.getValue());
    }

    private void incrementTotal(int value){
        total+= value;
    }

    public int getTotal() {
        return total;
    }
}
