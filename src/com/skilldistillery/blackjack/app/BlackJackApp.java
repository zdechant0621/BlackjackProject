package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();

	}

	public void run() {
		welcomeMenu();
		shuffleTheDeck();
		firstRound();
		playerTurn();
		replay();
	}

	public void welcomeMenu() {
		System.out.println("Welcome to Black Jack App!");
		System.out.println();
	}

	public void shuffleTheDeck() {
		dealer.shuffle();
	}

	public void firstRound() {
		player.addCard(dealer.dealCard(player.getHand()));
		dealer.addCard(dealer.dealCard(player.getHand()));
		player.addCard(dealer.dealCard(player.getHand()));
		dealer.addCard(dealer.dealCard(player.getHand()));
		System.out.println("Player's " + player.getHand());
		System.out.println("Player's card value is " + player.getHand().getHandValue());
		System.out.println();
		System.out.println("Dealer has a " + dealer.faceUpCard() + " showing");
		System.out.println("Dealer's card value is " + dealer.faceUpCard().getValue());
		System.out.println();
	}

	public void playerTurn() {
		int userInput = 0;
		if (((BlackjackHand) player.getHand()).isBlackjack() && dealer.getHand().getHandValue() < 21) {
			System.out.println("Blackjack! You've won!");

		} else {
			System.out.println("Would you like to Hit or Stand?");
			System.out.println("Enter 1 for Hit. Enter 2 for Stand.");
			while (player.getHand().getHandValue() < 21 && userInput != 2) {
				userInput = sc.nextInt();
				switch (userInput) {
				case 1:
					player.addCard(dealer.dealCard(player.getHand()));
					System.out.println("Player's card value is " + player.getHand().getHandValue());
					System.out.println("Player's " + player.getHand());
					if (((BlackjackHand) player.getHand()).isBust()) {
						System.out.println("House Wins!");
					}
					;
					if (((BlackjackHand) player.getHand()).isBlackjack() && dealer.getHand().getHandValue() < 21) {
						System.out.println("Blackjack! Player wins!");
						break;
					}
					break;
				case 2:
					System.out.println("You've chosen to stand.");
					dealerTurn();
					break;
				default:
					System.err.println("You've chosen an invalid input. Try again.");
				}
			}
		}

	}

	public void dealerTurn() {
		System.out.println();
		System.out.println("Dealer's turn");
		System.out.println("Dealer reveals " + dealer.getHand());
		System.out.println("Dealer Value: " + dealer.getHand().getHandValue());
		while (dealer.getHand().getHandValue() < 17) {
			System.out.println("Dealer hits");
			dealer.addCard(dealer.dealCard(player.getHand()));
			System.out.println("Dealer's " + dealer.getHand());
			System.out.println("Dealer Value: " + dealer.getHand().getHandValue());
			if (((BlackjackHand) dealer.getHand()).isBust()) {
				System.out.println("Player Wins!");
				break;
			}
			if (((BlackjackHand) dealer.getHand()).isBlackjack() && player.getHand().getHandValue() < 21) {
				System.out.println("Blackjack! House wins!");
				break;
			}

		}
		if (dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 20) {
			System.out.println("Dealer Stands");
			displayWinner();
		}

	}

	public void displayWinner() {
		if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
			System.out.println("House wins!");
		}
		if (dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			System.out.println("Player wins!");
		}
		if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("Push!");
		}
	}

	public void replay() {
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.println("Enter 1 for yes and 2 for no?");
		int userInput = sc.nextInt();
		switch (userInput) {
		case 1:
			player.getHand().clear();
			dealer.getHand().clear();
			run();
			break;
		case 2:
			System.out.println();
			System.out.println("Thanks for playing!");
			break;
		default:
			System.err.println("You've chosen an invalid input. Try again.");
		}
	}
}