package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
    private final Game game;
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Questions(Game game) {
        this.game = game;
    }

    void askQuestion() {
        if (game.currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (game.currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (game.currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (game.currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }
}