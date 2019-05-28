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

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        GameRepos.print(playerName + " was added");
        GameRepos.print("They are player number " + players.size());
        return true;
    }

    public boolean roll(int roll) {
        return currentPlayer().roll(roll);
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

}