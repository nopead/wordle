package main.java.logic.game.classes;

import main.java.logic.game.classes.GameSession;

public class RemainingAttemptsAnalyzer{
	
	GameSession gameSession;
	
	public RemainingAttemptsAnalyzer(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isAttemptsOver(){
		return (gameSession.attemptsRemaining < 1);
	}
}