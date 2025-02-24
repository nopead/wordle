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
	
	WordleMessagePrinter printer;
	WordleErrorPrinter errorPrinter;
	IReadable reader;
	
	public Wordle(){
		printer = new WordleMessagePrinter();
		errorPrinter = new WordleErrorPrinter();
		reader = new UserInputReader();
	}
	
	public void run(){
		printer.printGreeting();
		loadMainMenu();
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
		IGameService game = new GameServiceImpl();
		readAttempts(game);	
	}
	
	private void readAttempts(IGameService game){
		while (!game.isAttemptsOver()){
			printer.printInputTextRequest();
			String guessWord = reader.readWord().toLowerCase();
			if (!isInputTextInCorrectFormat(guessWord)){
				errorPrinter.printInputTextFormatErrorMessage();
				continue;
			}
			else if(!game.isUserInputIsWord(guessWord)){
				errorPrinter.printInputAsWordValidationFailMessage();
				continue;
			}
			else {
				if(game.isGuessWordIsAnswer(guessWord)){
					gameOverByAnswered();
					clearGame(game);
					break;
				}
				else{
					game.stateLetters(guessWord);
					game.decreaseRemainingAttemptsCount();
					printCurrentProgress(game);
				}
			}
		}
		clearGame(game);
		System.out.println("Secret word was: " + game.getGuessWord());
		gameOverByAttemptsOver();
	}
	
	private boolean isInputTextInCorrectFormat(String guessWord){
		return Pattern.compile("[a-z]*").matcher(guessWord).matches();
	}
	
	private void gameOverByAnswered(){
		printer.printCongratulations();
		loadMainMenu();
	}
	
	private void gameOverByAttemptsOver(){
		printer.printCompassion();
		loadMainMenu();
	}
	
	private void printCurrentProgress(IGameService game){
		String currentGuessState = game.getCurrentGuessedState();
		String notUsedLetters = game.getLettersThatWordNotContains();
		System.out.println("Your guess now: ");
		System.out.println(currentGuessState);
		System.out.println("Letters that guess word not contains:");
		System.out.println(notUsedLetters);
	}
	
	private void clearGame(IGameService game){
		game = null;
	}
}