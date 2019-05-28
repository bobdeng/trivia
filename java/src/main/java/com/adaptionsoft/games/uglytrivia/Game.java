package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Game {
	final Players players = new Players(this);

	LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

	public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return players.isPlayable();
	}

	public boolean add(String playerName) {


		return players.add(playerName);
	}
	
	public int howManyPlayers() {
		return players.howManyPlayers();
	}

	public void roll(int roll) {

		players.roll(roll);
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (players.places[players.currentPlayer] == 0) return "Pop";
		if (players.places[players.currentPlayer] == 4) return "Pop";
		if (players.places[players.currentPlayer] == 8) return "Pop";
		if (players.places[players.currentPlayer] == 1) return "Science";
		if (players.places[players.currentPlayer] == 5) return "Science";
		if (players.places[players.currentPlayer] == 9) return "Science";
		if (players.places[players.currentPlayer] == 2) return "Sports";
		if (players.places[players.currentPlayer] == 6) return "Sports";
		if (players.places[players.currentPlayer] == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		boolean result = players.wasCorrectlyAnswered();
		System.out.println("The category is " + currentCategory());
		askQuestion();
		return result;

	}
	
	public boolean wrongAnswer(){

		return players.wrongAnswer();
	}


	private boolean didPlayerWin() {
		return players.didPlayerWin();
	}

	public boolean isInPenaltyBox() {
		return players.isInPenaltyBox();
	}

	public int getGoldCoin() {
		return players.getGoldCoin();
	}
}
