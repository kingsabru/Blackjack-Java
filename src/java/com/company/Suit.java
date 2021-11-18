package com.company;

public enum Suit {
    HEART('H'), DIAMOND('D'), SPADE('S'), CLUB('C');

    private char letter;

    Suit(char letter){
        this.letter = letter;
    }
}
