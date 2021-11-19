package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private List<Player> players;
    private Deck deck;
    private boolean gameEnded;

    private int stickCount;

    public Game(){
        this.players = new ArrayList<>();
        this.deck = new Deck();
        gameEnded = false;
    }

    public void initializeGame(){
        Scanner scanner = new Scanner(System.in);
        int numOfPlayers;
        String response;

        for(int i = 0; ; i++) {
            System.out.print("How many people are playing? : ");

            response = scanner.nextLine();
            numOfPlayers = response.trim() == "" ? 3 : Integer.parseInt(response);

            if (numOfPlayers <= 1 || numOfPlayers > 6) {
                System.out.println("Invalid input. Players must be greater than 1 but less than or equal to 6.\n");
                continue;
            } else break;
        }

        createPlayers(numOfPlayers);
        shuffle();
    }

    public void shuffle(){
        System.out.println("\nShuffling Cards...\n");
        deck.shuffle();
    }

    public void createPlayers (int numOfPlayers) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("No. of Players: %d%n%n", numOfPlayers);

        for(int i = 1; i <= numOfPlayers; i++){
            System.out.printf("Player %d Name: ", i);
            String name = scanner.next();

            players.add(new Player(name, new DefaultStrategy()));
        }
    }

    public void dealCards(){
        for (int i=0; i<=1; i++) {
            players.forEach(p -> {
                Card card = deck.nextCard();
                p.addCard(card);
                System.out.printf("%s DEALT %s %s%n", p.getName(), card.getSuit(), card.getRank());
            });
        }
        System.out.println();

        printScores();
    }

    public void checkBlackJack(Player player){
        if(player.getHand().getTotal() == 21) {
            System.out.printf("%s has Blackjack!%n", player.getName());
            endGame();
        }
    }

    public void hitOrStick(Player player){
        if(!player.isBust()){
            switch(player.getAction()){
                case HIT:
                    Card card = deck.nextCard();
                    player.addCard(card);
                    System.out.printf("%s HIT %s %s", player.getName(), card.getSuit(), card.getRank());
                    break;
                default:
                    stickCount++;
                    System.out.printf("%s STICKS", player.getName());
                    break;
            }
            printScores(player);
            checkBust(player);
        }
    }

    private void printScores(){
        System.out.println("PLAYERS SCORE");

        players.forEach(p -> {
            System.out.printf("%s: %d%n", p.getName(), p.getHand().getTotal());
        });

        System.out.println();
    }

    private void printScores(Player player){
        System.out.printf(" [Score: %d]%n", player.getHand().getTotal());
    }

    public void checkBust(Player player){
        if (player.getHand().getTotal() >21) {
            player.setBust();
            System.out.printf("%s is BUST%n", player.getName());
        }
    }

    private void endGame(){
        gameEnded = true;
        System.out.println("GAME ENDED");
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void round(){
        for(Player player: players) {
            hitOrStick(player);
            checkBlackJack(player);
            if (gameEnded == true) return;
        };

        System.out.println();

        if(stickCount == players.size()) {
            getWinner().forEach(p -> {
                System.out.printf("%s WON with score: %d%n", p.getName(), p.getHand().getTotal());
            });
            endGame();
        }
        else stickCount = 0;

        players = players.stream().filter(p-> p.isBust()== false).toList();
    }

    // TODO: Refactor Code
    public List<Player> getWinner(){
        return players.stream()
                .filter( p -> p.getHand().getTotal() == players.stream()
                        .mapToInt(t -> t.getHand().getTotal()).max().orElse(0)).collect(Collectors.toList());
    }
}
