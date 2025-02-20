package main.java.logic.service.classes;

import java.util.HashMap;

public interface IGameService{
	
	public int getRemainingAttemptsCount();
	
	public void decreaseRemainingAttemptsCount();
	
	public void stateLetters(String guessWord);
	
	public String getCurrentGuessedState();
	
	public String getLettersThatWordNotContains();
	
	public boolean isAttemptsOver(); 
	
	public boolean isGuessWordIsAnswer(String guessWord);
	
	public boolean isUserInputIsWord(String input);
	
}