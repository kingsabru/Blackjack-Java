package com.company;

public class Main {

    public static void main(String[] args) {
        Game blackJack = new Game();
        blackJack.initializeGame();
        blackJack.dealCards();

        blackJack.getPlayers().forEach(p -> {blackJack.checkBlackJack(p);});;

        while(!blackJack.isGameEnded()){
           blackJack.round();
        }
    }
}
