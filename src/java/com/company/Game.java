package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Deck deck;
    // TODO: Add dealer (if has functionalities)

    public Game(){
        this.players = new ArrayList<>();
        this.deck = new Deck();
    }

    public void initializeGame(){
        Scanner scanner = new Scanner(System.in);
        int numOfPlayers;

        do {
            System.out.print("How many people are playing? : ");
            numOfPlayers = scanner.nextInt();
        } while (numOfPlayers < 0);

        for(int i = 1; i <= numOfPlayers; i++){
            System.out.printf("Player %d Name: ", i);
            String name = scanner.nextLine();

            players.add(new Player(name, new DefaultStrategy()));
        }

        // Shuffle Cards
        System.out.println("Shuffling Cards...");
        deck.shuffle();
    }

    public void dealCards(){
        for (int i=0; i<=1; i++) {
            players.forEach(p -> p.addCard(deck.nextCard()));
        }
    }

    public void checkBlackJack(){
        players.forEach(p -> {
            if(p.getHand().getTotal() == 21) {
                System.out.printf("%s has Blackjack!%n", p.getName());
            }
        });
    }

    public void hit(){
        players.forEach(p -> {
            if(p.getHand().getTotal() < 17) {
                p.addCard(deck.nextCard());
            }
        });
    }
}
