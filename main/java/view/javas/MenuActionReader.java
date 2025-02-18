package main.java.view.classes;

import java.util.Scanner;

class MenuActionReader implements IReadable{
	public int read(){
		try (Scanner sc = new Scanner(System.in)){
			
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
	
	
}