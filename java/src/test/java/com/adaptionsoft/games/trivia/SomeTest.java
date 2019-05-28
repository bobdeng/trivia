package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

public class SomeTest {

	@Test
	public void game_win() throws Exception {
		GameRepos.repo=new GameRepoImpl();
		Game game=new Game();
		game.add("alice");
		game.add("bob");
		for(int i=0;i<5;i++) {
			game.roll(1);
			game.roll(1);
		}
		game.roll(1);
		//checkGameHistory("game1.history");
	}

	private void checkGameHistory(String file) {
		String content=GameRepos.repo.toString();
		String fileContent=readFile(file);
		assertEquals(content,fileContent);
	}

	private String readFile(String file) {
		return null;
	}

	@Test
	public void game_penalty() throws Exception {
		Game game = new Game();
		game.add("alice");
		game.add("bob");
		//trun 1
		game.roll(1);
		game.wrongAnswer();
		game.roll(1);
		game.wrongAnswer();
		assertTrue(game.isInPenaltyBox());
		//turn 2
		game.roll(3);
		game.wasCorrectlyAnswered();
		assertTrue(game.isInPenaltyBox());
		assertEquals(game.getGoldCoin(),0);
		game.roll(2);
		game.wasCorrectlyAnswered();
		assertTrue(game.isInPenaltyBox());
		assertEquals(game.getGoldCoin(),1);
		//trun 3
		game.roll(3);
		game.wasCorrectlyAnswered();
		assertTrue(game.isInPenaltyBox());
		assertEquals(game.getGoldCoin(),0);
	}
}
