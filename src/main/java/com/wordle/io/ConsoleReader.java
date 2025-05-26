package com.wordle.io;

import java.util.Scanner;
import com.wordle.io.Readable;

public class ConsoleReader implements Readable{
	
	private final Scanner sc;
	
	public ConsoleReader(){
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