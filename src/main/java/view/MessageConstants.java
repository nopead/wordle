package main.java.view;

public final class MessageConstants{
	
	public static final String MAIN_MENU_TEXT = "=====MENU=====        \n" + 
												"Press 1 to start game.\n" + 
												"Press 2 to see rules. \n" + 
												"Press 3 to quit.	   \n" + 
												"==============        \n";
												
	public static final String GAME_OVER_MENU_TEXT = "=========Game is over!============\n" + 
													 "==================================\n" +
													 "Press 1 to start new game.		\n" + 
													 "Press 2 to go in main menu.		\n" + 
													 "Press 3 to quit.					\n" + 
													 "==================================\n";
													 
	public static final String GAME_RULES_TEXT = "=====================================================================GAME RULES==========================================================================		\n" + 
												 "The essence of the game is a secret five-letter word, which must be guessed in six attempts. 																	\n" + 
												 "After each move, the computer indicates whether the letter is in the right place, incorrect, or missing from the word. 										\n" +
												 "It is important that the attempts should be normal words, not random sequences like \"ddasd\"																	\n" +
												 "Hidden letter in output is \"*\", letter on wrong place are presented in lower case, like \"a\", letter on right place presented in upper case, like \"A\" 	\n" +  
												 "==========================================================================================================================================================	\n" +
												 "\n\n";
	
	public static final String COMPASSION_TEXT = "Unfortunatelly, you lose =( . Try again!";
	
	public static final String CONGRATULATION_TEXT = "CONGRATULATIONS!!! You guessed the word!";
	
	public static final String GREETING_TEXT = "Hello! Welcome to \"Wordle\" game!";
	
	public static final String INPUT_TEXT_REQUEST = "Type your guess:";
	
	private MessageConstants() {}
	
}