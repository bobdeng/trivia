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
    
    String getCurrentQuestion(int place){
        if (place == 0) return "Pop";
        if (place == 4) return "Pop";
        if (place == 8) return "Pop";
        if (place == 1) return "Science";
        if (place == 5) return "Science";
        if (place == 9) return "Science";
        if (place == 2) return "Sports";
        if (place == 6) return "Sports";
        if (place == 10) return "Sports";
        return "Rock";
    }


    void askQuestion(Player player) {
        String catagory = getCurrentQuestion(player.place);
        System.out.println("The category is " + catagory);
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