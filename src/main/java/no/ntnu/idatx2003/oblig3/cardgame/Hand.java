package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public int getSumOfFaces() {
        int sum = 0;
        for (PlayingCard card : cards) {
            int faceValue = card.getFace();
            if (faceValue >= 11 && faceValue <= 13) {
                // For face cards (jack, queen, king), use a value of 10
                sum += 10;
            } else {
                // For number cards, use their numeric value
                sum += faceValue;
            }
        }
        return sum;
    }

    public boolean isFlush() {
        if (cards.size() == 0) return false;

        boolean hasHeartsOrDiamonds = false;
        boolean hasSpadesOrClubs = false;

        for (PlayingCard card : cards) {
            char suit = card.getSuit();
            if (suit == 'H' || suit == 'D') {
                hasHeartsOrDiamonds = true;
            } else if (suit == 'S' || suit == 'C') {
                hasSpadesOrClubs = true;
            }
        }

        return (hasHeartsOrDiamonds && !hasSpadesOrClubs) || (!hasHeartsOrDiamonds && hasSpadesOrClubs);
    }

    public boolean hasQueenOfSpades() {
        for (PlayingCard card : cards) {
            if (card.getSuit() == 'S' && card.getFace() == 12) {
                return true;
            }
        }
        return false;
    }

    public boolean containsQueens() {
        for (PlayingCard card : cards) {
            if (card.getFace() == 12) { // Assuming 12 represents Queen
                return true;
            }
        }
        return false;
    }


}

