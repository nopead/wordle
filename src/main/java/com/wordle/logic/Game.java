package com.wordle.logic;

import java.util.List;
import java.util.ArrayList;
import com.wordle.model.Attempt;
import com.wordle.logic.validation.ValidationGateway;
import com.wordle.model.RecordAttemptResponse;
import com.wordle.model.ValidateResultResponse;
import com.wordle.config.Config;
import com.wordle.logic.GuessHandler;

public class Game {

	private final String hiddenWord;
	private final int allowedAttemptsCount;
	private final List<Attempt> attempts = new ArrayList<>();
	private final ValidationGateway validationGateway;
	private final GuessHandler guessHandler;

	public Game(Config config) {
		this.hiddenWord = config.getDictionaryRepository().getRandomWord();
		this.validationGateway = new ValidationGateway(config);
		this.allowedAttemptsCount = config.getAllowedAttemptsCount();
		this.guessHandler = new GuessHandler(hiddenWord);
	}

	public String getHiddenWord() {
		return hiddenWord;
	}

	public boolean isAttemptsOver() {
		return attempts.size() >= allowedAttemptsCount;
	}

	public boolean isGuessed() {
		if (!attempts.isEmpty()) {
			String lastAttempt = attempts.get(attempts.size() - 1).getGuess();
			return hiddenWord.equals(lastAttempt);
		} else return false;
	}

	public boolean isGameOver() {
		return isAttemptsOver() || isGuessed();
	}

	public int getRemainingAttemptsCount() {
		return allowedAttemptsCount - attempts.size();
	}

	public RecordAttemptResponse recordAttempt(String guess) {
		ValidateResultResponse result = validationGateway.validate(guess);
		if (result.isValid()) {
			attempts.add(new Attempt(guess));
			return new RecordAttemptResponse(true, "Attempt recorded successfully");
		}
		return new RecordAttemptResponse(false, "Attempt recorded failed");
	}

	public String getLastAttemptResult() {
		String lastAttempt = attempts.get(attempts.size() - 1).getGuess();
		return guessHandler.compareWithSecret(lastAttempt);
	}

}