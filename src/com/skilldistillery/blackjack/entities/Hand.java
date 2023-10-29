package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public abstract int getHandValue();

	public Hand() {

	}

	public void addCard(Card card) {
		hand.add(card);

	}

	public void clear() {
		hand.clear();

	}

	public Card dealerFaceUpCard(int dealerCard) {
		return hand.get(dealerCard);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("hand is ");
		builder.append(hand);
		builder.append(".");
		return builder.toString();
	}

}
