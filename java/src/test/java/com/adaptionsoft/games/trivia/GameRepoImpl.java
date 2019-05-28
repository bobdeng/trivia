package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRepoImpl implements GameRepo{
    List<String> history=new ArrayList<>();
    @Override
    public void printHistory(String his) {
        history.add(his);
    }

    @Override
    public String toString() {
        return history.stream()
                .collect(Collectors.joining("\n"));
    }
}
