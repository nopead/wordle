package main.java.logic.service.classes;

public interface IGameService{
	
	public void startGame();
	
	public String getLettersStates();
	
	public boolean isAttemptsOver(); 
	
	public boolean isGuessWordIsAnswer(String guessWord);
	
}