package com.adaptionsoft.games.uglytrivia;

public class Game {
	final Players players = new Players();
	final Questions questions = new Questions(this);

	public  Game(){
    	for (int i = 0; i < 50; i++) {
			questions.popQuestions.addLast("Pop Question " + i);
			questions.scienceQuestions.addLast(("Science Question " + i));
			questions.sportsQuestions.addLast(("Sports Question " + i));
			questions.rockQuestions.addLast(createRockQuestion(i));
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
		questions.askQuestion();
	}
	
	
	String currentCategory() {
		if (players.place() == 0) return "Pop";
		if (players.place() == 4) return "Pop";
		if (players.place() == 8) return "Pop";
		if (players.place() == 1) return "Science";
		if (players.place() == 5) return "Science";
		if (players.place() == 9) return "Science";
		if (players.place() == 2) return "Sports";
		if (players.place() == 6) return "Sports";
		if (players.place() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		boolean result = players.wasCorrectlyAnswered();
		System.out.println("The category is " + currentCategory());
		questions.askQuestion();
		return result;

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
