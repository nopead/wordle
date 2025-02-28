package main.java.view;

import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import main.java.view.Readable;

public class UserInputReader implements Readable{
	
	private final Scanner sc;
	
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