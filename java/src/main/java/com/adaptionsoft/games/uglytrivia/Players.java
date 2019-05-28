package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList();
    int currentPlayer = 0;

    public Players() {

    }

    private Player currentPlayer(){
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
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer().inPenalty) {
            if (roll % 2 != 0) {
                currentPlayer().isGettingOutOfPenaltyBox = true;

                System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayer().move(roll);

            } else {
                System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
                currentPlayer().isGettingOutOfPenaltyBox = false;
            }

        } else {

            currentPlayer().move(roll);

        }

    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer().inPenalty) {
            if (currentPlayer().isGettingOutOfPenaltyBox) {
                System.out.println("Answer was correct!!!!");
                currentPlayer().addGold();
                boolean winner = didPlayerWin();
                next();
                return winner;
            } else {
                next();
                return true;
            }


        } else {

            System.out.println("Answer was corrent!!!!");
            currentPlayer().addGold();

            boolean winner = didPlayerWin();
            next();

            return winner;
        }
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

    boolean didPlayerWin() {
        return !(currentPlayer().purse == 6);
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