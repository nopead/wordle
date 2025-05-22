package com.wordle.logic;

import java.util.List;
import java.util.ArrayList;
import com.wordle.logic.Attempt;

public class Game {

	public static final int ALLOWED_ATTEMPTS_COUNT = 6;
	public static final int WORDS_LENGTH = 5;

	private final String hiddenWord;
	private final List<Attempt> attempts = new ArrayList<>();
	
	public Game(String wordToGuess) {
		this.hiddenWord = wordToGuess;
	}

	public String getHiddenWord() {
		return hiddenWord;
	}

	public List<Attempt> getAttempts() {
		return attempts;
	}

	public void recordAttempt(String guess){
		attempts.add(new Attempt(guess));
	}

	public boolean isAttemptsOver() {
		return attempts.size() >= ALLOWED_ATTEMPTS_COUNT;
	}

	public boolean isGuessed() {
		if (attempts.isEmpty()){
			return hiddenWord.equals(attempts.get(attempts.size() - 1).getGuess());
		} else return false;
	}

	public boolean isGameOver() {
		return isAttemptsOver() || isGuessed();
	}

	public int getRemainingAttemptsCount() {
		return ALLOWED_ATTEMPTS_COUNT - attempts.size();
	}

}