package main.java.view.classes;
 
public class GameOverMenuPrinter implements IPrintable{
	public void print(){
		System.out.println("=========Game is over!============");
		System.out.println("==================================");
		System.out.println("Press 1 to start new game.\n" + 
						   "Press 2 to go in main menu.\n" + 
						   "Press 3 to quit."
		);
		System.out.println("==================================");
	}
	
	public void print(String str){
		
	}
}