package com.company;

public class AlwaysHitStrategy implements Strategy {
    @Override
    public Action getStrategy(int totalValue){
        return Action.HIT;
    }
}
