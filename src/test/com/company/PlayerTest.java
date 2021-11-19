package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("John Doe", new DefaultStrategy());
    }

    @Test
    void testPlayerCanAddCards() {
        player.addCard(new Card(Suit.CLUB, Rank.ACE));
        player.addCard(new Card(Suit.HEART, Rank.THREE));

        assertEquals(2, player.getHand().getCards().size());
    }

    @Test
    void testPlayerStrategy() {
        assertEquals(Action.HIT, player.getAction());
    }
}