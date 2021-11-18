package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card;

    @BeforeEach
    void setUp() {
        card =  new Card(Suit.CLUB, Rank.ACE);
    }

    @Test
    void testCardValue(){
        assertEquals(11, card.getValue());
    }
}