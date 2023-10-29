package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}

		return handValue;
	}

	public BlackjackHand() {

	}

	public boolean isBlackjack() {
		if (this.getHandValue() == 21) {
			return true;
		} else
			return false;

	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			System.out.println("Bust. Game Over!");
			return true;
		} else
			return false;

	}

}
