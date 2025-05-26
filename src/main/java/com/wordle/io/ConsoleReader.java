package io;

import java.util.Scanner;

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
 	
	public void close(){
		sc.close();
	}
	
}