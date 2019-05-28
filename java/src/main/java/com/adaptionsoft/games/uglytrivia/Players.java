package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList();
    int currentPlayer = 0;

    public Players() {

    }

    private Player currentPlayer() {
        return players.get(currentPlayer);
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        currentPlayer().roll(roll);

    }

    public boolean wasCorrectlyAnswered() {
        boolean result = currentPlayer().wasCorrectAnswered();
        next();
        return result;
    }

    private void next() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
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

    public int place() {
        return currentPlayer().place;
    }

}