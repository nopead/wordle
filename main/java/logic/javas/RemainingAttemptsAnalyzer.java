package main.java.logic.classes;

import main.java.logic.classes.GameSession;

public class RemainingAttemptsAnalyzer{
	
	GameSession gameSession;
	
	public RemainingAttemptsAnalyzer(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isGameOver(){
		return (gameSession.getAttemptsRemaining() < 1);
	}
}