package main.view;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import resources.ErrorConstant;

public class UserInputReader implements IReadable{
	
	private Scanner sc;
	
	public UserInputReader(){
		sc = new Scanner(System.in);
	}

	public int readDigit(){
		return(Integer.parseInt(sc.nextLine()));
	}
	
	public String readWord(){
		return sc.nextLine();
	} 	
}