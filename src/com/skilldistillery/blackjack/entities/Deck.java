package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> card = new ArrayList<>();

	public Deck() {
		card = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return card.size();
	}
	public void shuffle() {
		Collections.shuffle(card);
	}

	public Card dealCard() {
		Card dealtCard = card.remove(0);
		return dealtCard;

	}


}
