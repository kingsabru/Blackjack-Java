package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    Hand hand;

    @BeforeEach
    void setUp() {
        hand = new Hand();

        hand.addCard(new Card(Suit.CLUB, Rank.ACE));
        hand.addCard(new Card(Suit.HEART, Rank.THREE));
    }

    @Test
    void testAddingToHand() {
        hand.addCard(new Card(Suit.HEART, Rank.TWO));
        assertEquals(3, hand.getCards().size());
    }

    @Test
    void testHandTotalValue() {
        assertEquals(14, hand.getTotal());
    }
}