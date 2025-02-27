package main.java.view;

import main.view.MessageConstants;
import main.view.ErrorConstants;
import main.view.Readable;
import main.view.Printable;
import main.view.WordleMessagePrinter;
import main.view.UserInputReader;
import main.logic.service.GameService;
import main.logic.service.GameServiceImpl;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Wordle{
	
	private Printable printer;
	private Readable reader;
	private GameService game;
	
	public void run(){
		initUtils();
		printer.printGreeting();
		loadMainMenu();
	}
	
	private void initUtils(){
		this.printer = new WordleMessagePrinter();
		this.reader = new UserInputReader();
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
				printer.printMessage(ONLY_DIGITS_REQUIRED);
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
			printer.printMessage(INPUT_TEXT_REQUEST);
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
		else if (!game.isUserInputIsWord(guessWord)){
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