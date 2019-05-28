package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.GameRepos;

public class Player {
    String name;
    int purse;
    int place;
    boolean inPenalty;
    boolean isGettingOutOfPenaltyBox;
    public Player(String name) {
        this.name = name;
        purse=0;
        place=0;
        inPenalty=false;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addGold() {
        purse++;
        GameRepos.print(name
                + " now has "
                + purse
                + " Gold Coins.");
    }

    public void move(int roll) {
        place = place + roll;
        if (place > 11) place = place - 12;

        GameRepos.print(name
                + "'s new location is "
                + place);
    }

    public void wrongAnswer() {
        GameRepos.print(name + " was sent to the penalty box");
        inPenalty = true;
    }

    public void roll(int roll) {
        GameRepos.print(name + " is the current player");
        GameRepos.print("They have rolled a " + roll);
        if (!inPenalty || rollOutPenalty(roll)) {
            isGettingOutOfPenaltyBox = true;
            //GameRepos.print(name + " is getting out of the penalty box");
            move(roll);
            return;
        }
        GameRepos.print(name + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;

    }

    private boolean rollOutPenalty(int roll) {
        return roll %2!=0;
    }

    public void wasCorrectAnswered() {
        if (!inPenalty || isGettingOutOfPenaltyBox) {
            GameRepos.print("Answer was corrent!!!!");
            addGold();
            return;
        }
    }
    boolean didPlayerWin() {
        return purse != 6;
    }

}
