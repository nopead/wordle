package main.java.view.classes;

import main.java.view.classes.IPrintable;
import main.java.view.classes.IReadable;
import main.java.view.classes.GreetingPrinter;
import main.java.view.classes.MainMenuPrinter;
import main.java.view.classes.UserInputReader;
import main.java.view.classes.InputErrorPrinter;
import main.java.view.classes.IClearable;
import main.java.view.classes.ConsoleCleaner;


public class Wordle{
	
	private IReadable reader;
	private IClearable consoleCleaner;
	
	public Wordle(){
		reader = new UserInputReader();
		consoleCleaner = new ConsoleCleaner();
	}
	
	public void run(){
		printGreeting();
		loadMainMenu();
	}
	
	private void printGreeting(){
		IPrintable printer = new GreetingPrinter();
		printer.print();
	}
	
	private void printMainMenuText(){
		IPrintable printer = new MainMenuPrinter();
		printer.print();
	}
	
	private void printInputError(String msg){
		IPrintable printer = new InputErrorPrinter();
		printer.print(msg);
	}
	
	private void printGameRules(){
		IPrintable printer = new GameRulesPrinter();
		printer.print();
		loadMainMenu();
	}
	
	private void startGame(){}
	
	private void handleMainMenuUserResponce(){
		
		int responce = -1;
		do {
			responce = getMainMenuUserResponse();
			if(responce == 1){
				consoleCleaner.clear();
				startGame();
			}
			else if(responce == 2){
				consoleCleaner.clear();
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