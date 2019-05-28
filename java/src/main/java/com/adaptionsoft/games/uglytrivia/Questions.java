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
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }


    void askQuestion(String catagory) {
        if (catagory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (catagory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (catagory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (catagory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }
}