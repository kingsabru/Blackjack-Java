package com.company;

public class AlwaysStickStrategy implements Strategy {
    @Override
    public Action getStrategy(int totalValue){
        return Action.STICK;
    }
}
