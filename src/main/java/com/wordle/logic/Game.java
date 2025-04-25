package com.wordle.logic;

import java.util.List;
import java.util.ArrayList;
import com.wordle.logic.Attempt;

public class Game{
	
	private final int allowedAttemptsCount;
	private final String hiddenWord;

	private List<Attempt> attempts = new ArrayList<>();
	
	public Game(String wordToGuess){
		allowedAttemptsCount = 6;
		this.hiddenWord = wordToGuess;
	}
	
	public Game(String wordToGuess, int allowedAttemptsCount){
		this.hiddenWord = wordToGuess;
		this.allowedAttemptsCount = allowedAttemptsCount;
	}

	public String getHiddenWord() {
		return hiddenWord;
	}

	public boolean isAttemptsOver() {
		return attempts.size() >= allowedAttemptsCount;
	}
	
	public boolean isGuessWordIsAnswer() {
		return attempts.getLast().getGuess().equals(this.hiddenWord);
	}

	public List<Attempt> getAttempts() {
		return attempts;
	}

	public int getRemainingAttemptsCount(){
		return allowedAttemptsCount - attempts.size();
	}
	
	public void recordAttempt(String guess){
		attempts.add(new Attempt(guess));
	}
	
}