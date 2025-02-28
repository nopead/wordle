package main.java.view;

import main.java.repository.DictionaryRepository;
import main.java.repository.DictionaryRepositoryImplJson;
import main.java.view.MessageConstants;
import main.java.view.ErrorConstants;
import main.java.view.Readable;
import main.java.view.Printable;
import main.java.view.WordleMessagePrinter;
import main.java.view.UserInputReader;
import main.java.logic.Game;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Wordle{
	
	private Printable printer;
	private Readable reader;
	private Game game;
	private DictionaryRepository dictionaryRepository;
	
	public void run(){
		initUtils();
		printer.printMessage(MessageConstants.GREETING_TEXT);
		loadMainMenu();
	}
	
	private void initUtils(){
		this.printer = new WordleMessagePrinter();
		this.reader = new UserInputReader();
		this.dictionaryRepository = new DictionaryRepositoryImplJson();
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
		game = new Game(dictionaryRepository.getRandomWord(5));
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
		System.out.println("Secret word was: " + game.getHiddenWord());
		clearGame();
		loadMainMenu();
	}
	
	private void printCurrentProgress(){
		System.out.println("==Result of the attempt==");
		System.out.println("guess result: " + game.showAttemptEncryptResult());
		System.out.println("Remaining attempts count: " + game.getRemainingAttemptsCount());
		System.out.println("All right placed guessed letters: " + game.getRightPlacedLetters());
		System.out.println("All wrong placed guessed letters: " + game.getWrongPlacedLetters());
		System.out.println("All letter that not used in secret word: " + game.getNotUsedLetters());
	}
	
	private void clearGame(){
		this.game = null;
	}
	
}