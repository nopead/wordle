package com.wordle.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wordle.view.RightGuessLetterStater;
import com.wordle.view.WrongGuessLetterStater;
import com.wordle.view.UnusedGuessLetterStater;
import com.wordle.view.GuessLetterStater;
import com.wordle.view.MessageConstants;
import com.wordle.view.ErrorMessageConstants;
import com.wordle.view.Readable;
import com.wordle.view.UserInputReader;
import com.wordle.logic.GameManager;
import logic.RecordAttemptResponse;


public class Wordle {

	private final Readable reader;
	private final ArrayList<GuessLetterStater> staters;
	private final RightGuessLetterStater rightGuessLetterStater;
 	private final WrongGuessLetterStater wrongGuessLetterStater;
	private final UnusedGuessLetterStater unusedGuessLetterStater;

	private GameManager gameManager;

	public Wordle() {
		reader = new UserInputReader();
		rightGuessLetterStater = new RightGuessLetterStater();
		wrongGuessLetterStater = new WrongGuessLetterStater(rightGuessLetterStater);
		unusedGuessLetterStater = new UnusedGuessLetterStater();
		staters = new ArrayList<>(List.of(rightGuessLetterStater, wrongGuessLetterStater, unusedGuessLetterStater));
	}

	public void run() {
		System.out.println(MessageConstants.GREETING_TEXT);
		loadMainMenu();
	}
	
	void loadMainMenu() {
		System.out.println(MessageConstants.MAIN_MENU_TEXT);
		handleMainMenuUserResponse();
	}
	
	private void handleMainMenuUserResponse() {
		int responce = 0;
		do {
			try{ 
				responce = reader.readDigit();
				switch (responce) {
					case 1: {
						startGame();
						break;
					}
					case 2: {
						System.out.println(MessageConstants.GAME_RULES_TEXT);
						loadMainMenu();
						break;
					}
					case 3: {
						System.exit(0);
						break;
					}
					default: {
						System.out.println(ErrorMessageConstants.MAIN_MENU_OUT_OF_BOUNDS_EXCEPTION);
						break;
					}
				}
			} catch (NumberFormatException e){
				System.out.println(ErrorMessageConstants.ONLY_DIGITS_REQUIRED);
			}
		}
		while (responce < 1 || responce > 3);
	}

	private void startGame() {
		gameManager = new GameManager();
		gameManager.startNewGame();
		readAttempts();
	}

	private void readAttempts() {
		while (!gameManager.isGameOver()) {
			System.out.println(MessageConstants.INPUT_TEXT_REQUEST);
			String guess = reader.readWord().toLowerCase();
			RecordAttemptResponse attemptRecordResult = gameManager.tryRecordAttempt(guess);
			if (attemptRecordResult.isSuccess()) {
				handleAttemptResult(guess, attemptRecordResult.getMessage());
			}
			else {
				System.out.println(attemptRecordResult.getMessage());
			}
			System.out.println("Attempts remaining: " + gameManager.getRemainingAttemptsCount());
		}
		handleGameOver();
	}

	private void handleAttemptResult(String guess, String attemptResult) {
		unusedGuessLetterStater.setGuess(guess);
		stateGuessLetters(attemptResult);
		printDetailedResult(attemptResult);
	}

	private void printDetailedResult(String attemptResult){
		System.out.println("==========RESULT==========");
		System.out.println(attemptResult);
		printStatedLetters();
		System.out.println("==========================");
	}


	public void stateGuessLetters(String attemptResult) {
		staters.forEach(stater -> stater.state(attemptResult));
	}

	private void printStatedLetters() {
		staters.forEach(stater -> System.out.println(
				stater.getStateType() + ":" + stater.returnStated())
		);
	}

	private void clearStaters() {
		staters.forEach(GuessLetterStater::clear);
	}

	private void handleGameOver() {
		if (gameManager.isGuessed()) {
			System.out.println(MessageConstants.CONGRATULATION_TEXT);
		}else {
			System.out.println(MessageConstants.COMPASSION_TEXT);
			System.out.println("Secret word was: " + gameManager.getHiddenWord());
		}
		reload();
	}

	private void reload() {
		this.gameManager = null;
		clearStaters();
		loadMainMenu();
	}
	
}
