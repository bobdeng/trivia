package com.adaptionsoft.games.trivia;

public class Game {
	final Players players = new Players();
	final Questions questions = new Questions();

	public  Game(){
    }

	public boolean isPlayable() {
		return players.isPlayable();
	}

	public boolean add(String playerName) {
		return players.add(playerName);
	}

	public void roll(int roll) {
		players.roll(roll);
	}

	public boolean wasCorrectlyAnswered() {
		questions.askQuestion(players.currentPlayer());
		boolean playerNotWin = players.wasCorrectlyAnswered();
		return playerNotWin;

	}

	public boolean wrongAnswer(){
		return players.wrongAnswer();
	}


	public boolean isInPenaltyBox() {
		return players.isInPenaltyBox();
	}

	public int getGoldCoin() {
		return players.getGoldCoin();
	}
}
