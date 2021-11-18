package com.company;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + this.getRank() +
                '}';
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }
}
