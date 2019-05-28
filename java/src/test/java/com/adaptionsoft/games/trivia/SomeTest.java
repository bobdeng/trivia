package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class SomeTest {
	@Before
	public void setUp() throws Exception {
		GameRepos.repo=new GameRepoImpl();
	}

	@Test
	public void game_start() throws Exception{
		Game game=new Game();
		game.add("alice");
		game.add("bob");
		checkGameHistory("game_start.history");
	}

	@Test
	public void game_play_once() throws Exception{
		Game game=new Game();
		game.add("alice");
		game.add("bob");
		game.roll(1);
		game.wasCorrectlyAnswered();
		checkGameHistory("game_play_step1.history");
		game.roll(4);
		game.wrongAnswer();
		checkGameHistory("game_play_step2.history");
		game.roll(4);
		game.wasCorrectlyAnswered();
		checkGameHistory("game_play_step3.history");
	}


	@Test
	public void game_win() throws Exception {

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

	private void checkGameHistory(String file)throws Exception {
		String content=GameRepos.repo.toString();
		String fileContent=readFile(file);
		assertEquals(content,fileContent);
	}

	private String readFile(String file) throws Exception{
		InputStream intputStream = getClass().getClassLoader().getResourceAsStream(file);
		byte[] data=new byte[intputStream.available()];
		intputStream.read(data);
		intputStream.close();
		return new String(data);
	}

	
}
