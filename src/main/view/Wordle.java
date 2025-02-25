package main.view;

import main.view.IReadable;
import main.view.WordleMessagePrinter;
import main.view.WordleErrorPrinter;
import main.view.UserInputReader;
import main.logic.service.IGameService;
import main.logic.service.GameServiceImpl;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Wordle{
	
	private WordleMessagePrinter printer;
	private WordleErrorPrinter errorPrinter;
	private IReadable reader;
	private IGameService game;
	
	public void run(){
		initUtils();
		printer.printGreeting();
		loadMainMenu();
	}
	
	private void initUtils(){
		this.printer = new WordleMessagePrinter();
		this.errorPrinter = new WordleErrorPrinter();
		this.reader = new UserInputReader();
	}
	
	void loadMainMenu(){
		printer.printMainMenu();
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
					printer.printGameRules();
					loadMainMenu();
				}
				else if(responce == 3){
					System.exit(0);
				}	
				else {
					errorPrinter.printMainMenuOutOfBoundsExceptionMessage();
				}
			} catch (NumberFormatException e){
				errorPrinter.printNumberFormatExceptionMessage();
			}
		}
		while (responce < 1 || responce > 3);
	}
	
	private void startGame(){
		game = new GameServiceImpl();
		readAttempts();	
	}
	
	private void readAttempts(){
		while (!game.isAttemptsOver()){
			printer.printInputTextRequest();
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
			errorPrinter.printInputTextFormatErrorMessage();
			return false;
		}
		else if (guessWord.length() < game.getHiddenWord().length()){
			errorPrinter.printGuessWordLengthShorterMessage();
			return false;
		}
		else if (guessWord.length() > game.getHiddenWord().length()){
			errorPrinter.printGuessWordLengthLongerMessage();
			return false;
		}
		else if (!game.isUserInputIsWord(guessWord)){
			errorPrinter.printInputAsWordValidationFailMessage();
			return false;
		}
		else{
			return true;
		}
	}
	
	private void gameOverByAnswered(){
		printer.printCongratulations();
		clearGame();
		loadMainMenu();
	}
	
	private void gameOverByAttemptsOver(){
		printer.printCompassion();
		System.out.println("Secret word was: " + game.getHiddenWord());
		clearGame();
		loadMainMenu();
	}
	
	private void printCurrentProgress(){
		System.out.println("==Result of the attempt==");
		System.out.println("guess result: " + game.getAttemptGuessResult());
		System.out.println("Remaining attempts count: " + game.getRemainingAttemptsCount());
		System.out.println("All right placed guessed letters: " + game.getAllRightPlacedLetters());
		System.out.println("All wrong placed guessed letters: " + game.getAllWrongPlacedLetters());
		System.out.println("All letter that not used in secret word: " + game.getAllNotUsedLetters());
	}
	
	private void clearGame(){
		this.game = null;
	}
}