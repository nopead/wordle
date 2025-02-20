package main.java.view.classes;

import java.util.Scanner;
import java.io.IOException;
import main.java.view.classes.IPrintable;
import main.java.view.classes.InputErrorPrinter;

class UserInputReader implements IReadable{
	
	Scanner sc;
	
	private static final String ONLY_DIGITS_REQUIRED = "You must use digits in menu input";
	private static final String ONLY_LATTIN_LETTERS_REQUIRED = "You must use combination that consist only from lattin letters.";
	
	UserInputReader(){
		sc = new Scanner(System.in);
	}
	
	public int readDigit(){
		while (sc.hasNextLine()){
			try{
				int input = Integer.parseInt(sc.nextLine());
				return input;
			} catch (NumberFormatException e){
				IPrintable printer = new InputErrorPrinter();
				printer.print(ONLY_DIGITS_REQUIRED);
			}
		}
		return -1;
	}
	
	public String readWord(){
		String input = sc.nextLine();
		return input;
	} 	
}