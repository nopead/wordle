package com.wordle.view;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryRepositoryImplJson;
import com.wordle.view.MessageConstants;
import com.wordle.view.ErrorConstants;
import com.wordle.view.Readable;
import com.wordle.view.Printable;
import com.wordle.view.WordleMessagePrinter;
import com.wordle.view.UserInputReader;
import com.wordle.logic.Game;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Wordle{
	
	private final Printable printer = new WordleMessagePrinter();
	private final Readable reader = new UserInputReader();
	
	private DictionaryRepository dictionaryRepository = new DictionaryRepositoryImplJson();
	private Game game;
	
	public void run(){
		printer.printMessage(MessageConstants.GREETING_TEXT);
		loadMainMenu();
	}
	
	void loadMainMenu(){
		printer.printMessage(MessageConstants.MAIN_MENU_TEXT);
		handleMainMenuUserResponce();
	}
	
	private void handleMainMenuUserResponce(){
		int responce = 0;
		do {
			try{ 
				responce = reader.readDigit();
				if(responce == 1){
					startGame();
				}
				else if(responce == 2){
					printer.printMessage(MessageConstants.GAME_RULES_TEXT);
					loadMainMenu();
				}
				else if(responce == 3){
					System.exit(0);
				}	
				else {
					printer.printMessage(ErrorConstants.MAIN_MENU_OUT_OF_BOUNDS_EXCEPTION);
				}
			} catch (NumberFormatException e){
				printer.printMessage(ErrorConstants.ONLY_DIGITS_REQUIRED);
			}
		}
		while (responce < 1 || responce > 3);
	}

	private void startGame(){
		dictionaryRepository.readDictionary(5);
		game = new Game(dictionaryRepository.getRandomWord());
		readAttempts();	
	}
	
	private void readAttempts(){
		while (!game.isAttemptsOver()){
			printer.printMessage(MessageConstants.INPUT_TEXT_REQUEST);
			String guessWord = reader.readWord().toLowerCase();
			if (isInputFormatCorrect(guessWord)){
				if(game.isGuessWordIsAnswer(guessWord)){
					game.recordAttempt(guessWord);
					game.stateLetters();
					gameOverByAnswered();
					return;
				}
				else{
					game.recordAttempt(guessWord);
					game.stateLetters();
					printCurrentProgress();
				}
			}
		}
		gameOverByAttemptsOver();
	}

	private boolean isInputFormatCorrect(String guessWord){
		if (!Pattern.compile("^[a-z]*").matcher(guessWord).matches()){
			printer.printMessage(ErrorConstants.ONLY_LATTIN_LETTERS_REQUIRED);
			return false;
		}
		else if (guessWord.length() < game.getHiddenWord().length()){
			printer.printMessage(ErrorConstants.INPUT_TEXT_LENGTH_SHORTER);
			return false;
		}
		else if (guessWord.length() > game.getHiddenWord().length()){
			printer.printMessage(ErrorConstants.INPUT_TEXT_LENGTH_LONGER);
			return false;
		}
		else if (!dictionaryRepository.isDictionaryContainsWord(guessWord)){
			printer.printMessage(ErrorConstants.SEQUENCE_IS_NOT_WORD);
			return false;
		}
		else{
			return true;
		}
	}
	
	private void gameOverByAnswered(){
		printer.printMessage(MessageConstants.CONGRATULATION_TEXT);
		clearGame();
		loadMainMenu();
	}
	
	private void gameOverByAttemptsOver(){
		printer.printMessage(MessageConstants.COMPASSION_TEXT);
		printer.printMessage("Secret word was: " + game.getHiddenWord());
		clearGame();
		loadMainMenu();
	}
	
	private void printCurrentProgress(){
		printer.printMessage("==Result of the attempt==");
		printer.printMessage("guess result: " + game.showAttemptEncryptResult());
		printer.printMessage("Remaining attempts count: " + game.getRemainingAttemptsCount());
		printer.printMessage("All right placed guessed letters: " + game.getRightPlacedLetters());
		printer.printMessage("All wrong placed guessed letters: " + game.getWrongPlacedLetters());
		printer.printMessage("All letter that not used in secret word: " + game.getNotUsedLetters());
	}
	
	private void clearGame(){
		this.game = null;
	}
	
}