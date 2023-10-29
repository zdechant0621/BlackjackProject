package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck = new Deck();

	public Dealer() {

	}

	public void shuffle() {
		deck.shuffle();
	}

	public Card dealCard(Hand hand) {
		return deck.dealCard();

	}
	
	public Card faceUpCard() {
		return hand.dealerFaceUpCard(1);
	}

}
