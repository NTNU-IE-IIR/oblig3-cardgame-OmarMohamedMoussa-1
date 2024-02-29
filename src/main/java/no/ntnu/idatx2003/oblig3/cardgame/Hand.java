package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<String> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(String card) {
        cards.add(card);
    }

    public boolean isFlush() {
        if (cards.size() == 0) return false;

        char suit = cards.get(0).charAt(1);
        for (String card : cards) {
            if (card.charAt(1) != suit) {
                return false;
            }
        }
        return true;
    }
}
