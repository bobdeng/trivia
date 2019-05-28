package com.adaptionsoft.games.trivia;

public class GameRepos {
    public static GameRepo repo;

    public static void print(String log){
        repo.printHistory(log);
    }
}
