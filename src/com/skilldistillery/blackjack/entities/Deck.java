package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> card = new ArrayList<>(52);

	

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				card.add(new Card(rank, suit));
			}
		}
		return;
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
