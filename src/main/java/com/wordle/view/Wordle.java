package com.wordle.view;

import java.util.ArrayList;
import com.wordle.view.GuessLetterStater;

public class Wordle {

	private final Readable reader = new UserInputReader();

	private ArrayList<com.wordle.view.GuessLetterStater> staters;

	private void initLetterStaters() {
		staters.add(new RightLetterStater());
		staters.add(new WrongLetterStater());
		staters.add(new UnusedLetterStater());
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
		//GameService
		//readAttempts();
	}

	public void stateGuessLetters(String guess) {
		staters.forEach(stater -> stater.state(guess));
	}

	private void clearStaters() {
		staters.forEach(stater -> stater.clear());
	}


	//TODO: передать логику классу сервису игры
	/*
	private void readAttempts(){
		while (!game.isAttemptsOver()){
			System.out.println(MessageConstants.INPUT_TEXT_REQUEST);
			String guessWord = reader.readWord().toLowerCase();
			if (isInputWordValid(guessWord)){
//				game.recordAttempt(guessWord);
//				game.stateLetters();
//				if(game.isGuessWordIsAnswer(guessWord)){
//					gameOverByAnswered();
//					return;
//				}
//				else{
					System.out.println("=====================Result of the attempt===========================" + "\n" +
							 "guess result: " + game.showAttemptEncryptResult() + "\n" +
							 "Remaining attempts count: " + game.getRemainingAttemptsCount() + "\n" + 
							 "All right placed guessed letters: " + game.getRightPlacedLetters() + "\n" +
							 "All wrong placed guessed letters: " + game.getWrongPlacedLetters() + "\n" + 
						     "All letter that not used in secret word: " + game.getNotUsedLetters() + "\n" + 
							 "====================================================================="
					);
				}
			}
		}
		gameOverByAttemptsOver();
	}*/

	private void gameOverByAnswered() {
		System.out.println(MessageConstants.CONGRATULATION_TEXT);
		clearGame();
		loadMainMenu();
	}
	
	private void gameOverByAttemptsOver() {
		System.out.println(MessageConstants.COMPASSION_TEXT);
		//System.out.println("Secret word was: " + game.getHiddenWord());
		clearGame();
		loadMainMenu();
	}

	private void clearGame() {
		//this.game = null;
	}
	
}