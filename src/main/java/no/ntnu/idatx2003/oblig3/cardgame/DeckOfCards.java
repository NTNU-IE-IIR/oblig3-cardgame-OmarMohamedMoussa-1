package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Random;



public class DeckOfCards {

    private final char[] suits = {'S', 'H', 'D', 'C'};
    private final int[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1}; // Ace is represented as 1

    private List<PlayingCard> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        addAllCards();
        shuffle();
    }

    private void addAllCards() {
        for (char suit : suits) {
            for (int rank : ranks) {
                deck.add(new PlayingCard(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<PlayingCard> dealHand(int n) {
        List<PlayingCard> hand = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hand.add(deck.remove(0)); // Remove card from top of deck
        }
        return hand;
    }






}
