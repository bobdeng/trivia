package com.adaptionsoft.games.uglytrivia;

public class Player {
    String name;
    int purse;
    int place;

    public Player(String name) {
        this.name = name;
        purse=0;
        place=0;
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
}
