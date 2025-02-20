package main.java.logic.service.classes;

public interface IGameService{
	
	public int getRemainingAttemptsCount();
	
	public void startGame();
	
	public void decreaseRemainingAttemptsCount();
	
	public void stateLetters(String guessWord);
	
	public String getLettersStates();
	
	public boolean isAttemptsOver(); 
	
	public boolean isGuessWordIsAnswer(String guessWord);
	
	public boolean isUserInputIsWord(String input);
	
}