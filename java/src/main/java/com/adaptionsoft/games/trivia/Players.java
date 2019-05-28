package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList();
    int currentPlayer = 0;

    public Players() {

    }

    Player currentPlayer() {
        return players.get(currentPlayer);
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        GameRepos.print(playerName + " was added");
        GameRepos.print("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        currentPlayer().roll(roll);
    }

    public boolean wasCorrectlyAnswered() {
        currentPlayer().wasCorrectAnswered();
        boolean result = currentPlayer().didPlayerWin();
        next();
        return result;
    }

    private void next() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        GameRepos.print("Question was incorrectly answered");
        currentPlayer().wrongAnswer();
        next();
        return true;
    }


    public boolean isInPenaltyBox() {
        return currentPlayer().inPenalty;
    }

    public int getGoldCoin() {
        return currentPlayer().purse;
    }

}