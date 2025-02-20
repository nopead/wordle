package main.java.view.classes;

import java.util.Scanner;
import java.io.IOException;
import main.java.view.classes.IPrintable;
import main.java.view.classes.InputErrorPrinter;

class UserInputReader implements IReadable{
	
	Scanner sc;
	
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
				printer.print("You must use digits in menu input.");
			}
		}
		return -1;
	}
	
	public String readWord(){
		String input = "";
		try (Scanner sc = new Scanner(System.in)){
			return input;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return input;
	} 	
}