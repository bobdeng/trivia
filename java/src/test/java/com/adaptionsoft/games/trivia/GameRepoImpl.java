package com.adaptionsoft.games.trivia;

import java.util.ArrayList;
import java.util.List;

public class GameRepoImpl implements GameRepo{
    List<String> history=new ArrayList<>();
    @Override
    public void printHistory(String his) {
        history.add(his);
    }
}
