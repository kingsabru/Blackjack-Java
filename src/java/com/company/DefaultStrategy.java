package com.company;

public class DefaultStrategy implements Strategy {
    public Action getStrategy(int totalValue){
        if(totalValue < 17) return Action.HIT;
        else return Action.STICK;
    }
}
