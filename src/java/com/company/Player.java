package com.company;

public class Player {
    private final String name;
    private Hand hand;
    private Strategy strategy;
    private boolean isBust;

    public Player(String name, Strategy strategy){
        this.name = name;
        this.strategy = strategy;
        isBust = false;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return isBust;
    }

    // TODO: May be refactored
    public void setBust() {
        if(hand.getTotal() > 21)
        isBust = !isBust;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public Action getAction(){
        return strategy.getStrategy(hand.getTotal());
    }
}
