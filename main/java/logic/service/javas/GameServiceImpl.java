package main.java.logic.service.classes;

import main.java.logic.service.classes.IGameService;
import main.java.logic.game.classes.GameSession;

public class GameServiceImpl implements IGameService{
	
	private GameSession gameSession;
	
	public void startGame(){
		gameSession = new GameSession();
	}
	
	public boolean isAttemptsOver(){
		return gameSession.remainingAttemptsAnalyzer.isAttemptsOver();
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return gameSession.guessWordAnalyzer.compareWithSecret(guessWord);
	}
	
	public String getLettersStates(){
		return "";
	}
}