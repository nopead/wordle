package main.logic.service;

import java.util.HashMap;

public interface IGameService{
	
	public boolean isAttemptsOver(); 
	
	public boolean isGuessWordIsAnswer(String guessWord);
	
	public boolean isUserInputIsWord(String input);
	
	public String getAttemptGuessResult();
	
	public void stateLetters();

	public int getRemainingAttemptsCount();
	
	public void recordAttempt(String guess);
	
	public String getHiddenWord();
	
	public String getAllRightPlacedLetters();
	
	public String getAllWrongPlacedLetters();
	
	public String getAllNotUsedLetters();
}