package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.GameRepos;

import java.util.LinkedList;

public class Questions {
    LinkedList<String> popQuestions = new LinkedList();
    LinkedList<String>  scienceQuestions = new LinkedList();
    LinkedList<String>  sportsQuestions = new LinkedList();
    LinkedList<String>  rockQuestions = new LinkedList();

    public Questions() {
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
        GameRepos.print("The category is " + catagory);
        if (catagory.equals("Pop"))
            GameRepos.print(popQuestions.removeFirst());
        if (catagory.equals("Science"))
            GameRepos.print(scienceQuestions.removeFirst());
        if (catagory.equals("Sports"))
            GameRepos.print(sportsQuestions.removeFirst());
        if (catagory.equals("Rock"))
            GameRepos.print(rockQuestions.removeFirst());
    }
}