package com.adaptionsoft.games.trivia;

public class Game {
	final Players players = new Players();
	final Questions questions = new Questions();

	public  Game(){
    }

	public boolean add(String playerName) {
		return players.add(playerName);
	}

	public void roll(int roll) {
		if (players.roll(roll)) {
			questions.askQuestion(players.currentPlayer());
		}
	}

	public boolean wasCorrectlyAnswered() {
		return players.wasCorrectlyAnswered();

	}

	public boolean wrongAnswer(){
		return players.wrongAnswer();
	}

}
