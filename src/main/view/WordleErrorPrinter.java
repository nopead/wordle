package main.view;

import resources.ErrorConstant;

public class WordleErrorPrinter{
	
	public static void printNumberFormatExceptionMessage(){
		System.out.println(ErrorConstant.ONLY_DIGITS_REQUIRED);
	}
	
	public static void printInputTextFormatErrorMessage(){
		System.out.println(ErrorConstant.ONLY_LATTIN_LETTERS_REQUIRED);
	} 
	
	public static void printInputAsWordValidationFailMessage(){
		System.out.println(ErrorConstant.SEQUENCE_IS_NOT_WORD);
	}
	
	public static void printMainMenuOutOfBoundsExceptionMessage(){
		System.out.println(ErrorConstant.MAIN_MENU_OUT_OF_BOUNDS_EXCEPTION);
	}
} 