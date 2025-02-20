package main.java.view.classes;

import main.java.view.classes.IPrintable;
import main.java.view.classes.IReadable;
import main.java.view.classes.IClearable;
import main.java.logic.service.classes.IGameService;

import main.java.view.classes.GreetingPrinter;
import main.java.view.classes.MainMenuPrinter;
import main.java.view.classes.UserInputReader;
import main.java.view.classes.InputErrorPrinter;
import main.java.view.classes.ConsoleCleaner;
import main.java.logic.service.classes.GameServiceImpl;

public class Wordle{
	
	private IReadable reader;
	private IClearable consoleCleaner;
	private IPrintable printer;
	
	public Wordle(){
		reader = new UserInputReader();
		consoleCleaner = new ConsoleCleaner();
	}
	
	public void run(){
		printGreeting();
		loadMainMenu();
	}
	
	private void printGreeting(){
		printer = new GreetingPrinter();
		printer.print();
	}
	
	private void printMainMenuText(){
		printer = new MainMenuPrinter();
		printer.print();
	}
	
	private void printInputError(String msg){
		printer = new InputErrorPrinter();
		printer.print(msg);
	}
	
	private void printGameRules(){
		printer = new GameRulesPrinter();
		printer.print();
		loadMainMenu();
	}
	
	private void printCompassionMessage(){
		printer = new CompassionPrinter();
		printer.print();
	}
	
	private void printSequenceIsNotWordError(){
		printer = new InputErrorPrinter();
		printer.print("Input sequence is not a word");
	}
	
	private String readUserGuess(){
		return reader.readWord();	
	}
	
	private void gameOverByAttemptsOver(){
		printCompassionMessage();
		loadMainMenu();
	}
	
	private void gameOverByAnswered(){
		printer = new CongratulationsPrinter();
		printer.print();
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
	
	private void readAttempts(IGameService game){
		while (!game.isAttemptsOver()){
			String guessWord = readUserGuess();
			if(!game.isUserInputIsWord(guessWord)){
				printSequenceIsNotWordError();
				continue;
			}
			else {
				if(!game.isGuessWordIsAnswer(guessWord)){
					game.stateLetters(guessWord);
					game.decreaseRemainingAttemptsCount();
					printCurrentProgress(game);
				}
				else{
					gameOverByAnswered();
				}
			}
		}
		game = null;
		gameOverByAttemptsOver();
	}
	
	private void startGame(){
		IGameService game = new GameServiceImpl();
		readAttempts(game);	
	}
	
	private void handleMainMenuUserResponce(){
		int responce;
		do {
			responce = getMainMenuUserResponse();
			if(responce == 1){
				startGame();
			}
			else if(responce == 2){
				printGameRules();
			}
			else if(responce == 3){
				System.exit(0);
			}	
			else {
				printInputError("Input values must be between 1 and 3 inclusive");
			}
		}
		while (responce < 1 || responce > 3);
	}
	
	 void loadMainMenu(){
		printMainMenuText();
		handleMainMenuUserResponce();
	}
	
	private int getMainMenuUserResponse(){
		return reader.readDigit();
	}
}