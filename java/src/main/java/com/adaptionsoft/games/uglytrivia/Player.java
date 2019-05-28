package com.adaptionsoft.games.uglytrivia;

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
        System.out.println(name
                + " now has "
                + purse
                + " Gold Coins.");
    }

    public void move(int roll) {
        place = place + roll;
        if (place > 11) place = place - 12;

        System.out.println(name
                + "'s new location is "
                + place);
    }

    public void wrongAnswer() {
        System.out.println(name + " was sent to the penalty box");
        inPenalty = true;
    }

    public void roll(int roll) {
        System.out.println(name + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenalty) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(name + " is getting out of the penalty box");
                move(roll);

            } else {
                System.out.println(name + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            move(roll);

        }
    }
}
