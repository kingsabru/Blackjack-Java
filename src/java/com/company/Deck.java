package com.company;

import java.util.*;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    public Deck() {
        for(Suit suit: Suit.values()){
            for(Rank value: Rank.values()){
                cards.push(new Card(suit, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card nextCard(){
        return cards.pop();
    }
}
