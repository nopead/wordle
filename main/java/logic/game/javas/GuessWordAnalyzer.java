package main.java.logic.game.classes;

import main.java.logic.game.classes.GameSession;

public class GuessWordAnalyzer{
	
	private GameSession gameSession;
	
	public GuessWordAnalyzer(GameSession gameSession){
		this.gameSession = gameSession;
	}
		
	public boolean compareWithSecret(String userWord){
		return userWord.equals(gameSession.WORD_TO_GUESS);
	}
}
