package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
	public void game_full() throws Exception{
		Game game=new Game();
		game.add("alice");
		game.add("bob");
		Arrays.asList(
			new GameStep(1,false),
			new GameStep(2,true),
			new GameStep(1,true),
			new GameStep(2,true),
			new GameStep(4,true),
			new GameStep(4,true),
			new GameStep(4,true),
			new GameStep(6,true),
			new GameStep(2,true),
			new GameStep(2,true),
			new GameStep(4,true),
			new GameStep(3,true)
		).forEach(gameStep -> {
			game.roll(gameStep.step);
			if(gameStep.right){
				game.wasCorrectlyAnswered();
			}else{
				game.wrongAnswer();
			}
		});
		checkGameHistory("game_full.history");

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
