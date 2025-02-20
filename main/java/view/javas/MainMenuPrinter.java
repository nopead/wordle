package main.java.view.classes;

public class MainMenuPrinter implements IPrintable{
	public void print(){
		System.out.println("=====MENU=====");
		System.out.println("Press 1 to start game.\n" + 
						   "Press 2 to see rules.\n" + 
						   "Press 3 to quit."
		);
		System.out.println("==============");
	}
	
	public void print(String str){
		
	}
}