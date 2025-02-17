package main.java.logic.classes;

import main.java.logic.classes.GameSession;

public class NoMoreAttemptsChecker{
	
	GameSession gameSession;
	
	public NoMoreAttemptsChecker(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isGameOver(){
		return (gameSession.getAttemptsRemaining() < 1);
	}
}