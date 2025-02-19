package main.java.logic.game.classes;

public class RemainingAttemptsDecreaser{
	private GameSession gameSession;
	
	public RemainingAttemptsDecreaser(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public void decrease(){
		this.gameSession.attemptsRemaining -= (this.gameSession.attemptsRemaining > 0) ? 1 : 0;
	}
}