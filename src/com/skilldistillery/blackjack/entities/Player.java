package com.skilldistillery.blackjack.entities;
//Player receives 2 cards in their hand

public class Player {
	protected Hand hand = new BlackjackHand();
	
	public Player() {
		
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
