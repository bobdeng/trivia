package com.adaptionsoft.games.uglytrivia;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
