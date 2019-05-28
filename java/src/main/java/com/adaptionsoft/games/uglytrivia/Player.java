package com.adaptionsoft.games.uglytrivia;

public class Player {
    String name;
    int purse;

    public Player(String name) {
        this.name = name;
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
}
