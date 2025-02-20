package main.java.view.classes;

class GameRulesPrinter implements IPrintable{
	public void print(){
		System.out.println("=====GAME RULES=====");
		System.out.println("The essence of the game is a secret five-letter word, which must be guessed in six attempts.");
		System.out.println("After each move, the computer indicates whether the letter is in the right place, incorrect, or missing from the word.");
		System.out.println("It is important that the attempts should be normal words, not random sequences like \"ddasd\"");
		System.out.println("Hidden letter in output is \"*\", letter on wrong place are presented in lower case, like \"a\", letter on right place presented in upper case, like \"A\"");
		System.out.println("====================");
		System.out.println("\n\n");
	}
	
	public void print(String str){}
}