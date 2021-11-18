package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck;
    @BeforeEach
    void setUp() {
        deck = new Deck();
        deck.shuffle();
    }


}