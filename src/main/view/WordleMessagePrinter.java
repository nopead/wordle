package main.view;

import resources.StringConstant;

public class WordleMessagePrinter{
	
	public static void printMainMenu(){
		System.out.println(StringConstant.MAIN_MENU_TEXT);
	}
	
	public static void printGreeting(){
		System.out.println(StringConstant.GREETING_MESSAGE_TEXT);
	}
	
	public static void printCompassion(){
		System.out.println(StringConstant.COMPASSION_MESSAGE_TEXT);
	}
	
	public static void printGameOverMenu(){
		System.out.println(StringConstant.GAME_OVER_MENU_TEXT);
	}
	
	public static void printCongratulations(){
		System.out.println(StringConstant.CONGRATULATION_MESSAGE_TEXT);
	}
	
	public static void printGameRules(){
		System.out.println(StringConstant.GAME_RULES_TEXT);
	}
	
	public static void printInputTextRequest(){
		System.out.println(StringConstant.INPUT_TEXT_REQUEST_MESSAGE);
	}
}