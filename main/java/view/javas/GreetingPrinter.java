package main.java.view.classes;

public class GreetingPrinter implements IPrintable{
	public void print(){
		System.out.println("Hello, player! Welcome to \"Wordle\" game!");
	}
	
	public void print(String player){
		System.out.println("Hello, " + player + "! Welcome to \"Wordle\" game!");
	}
}