package main.java.logic.classes;

import java.util.Set;
import java.util.Arrays;

public class InputValidator{
	public static boolean isMatch(String input){
		return false;
	}
	
	public static boolean isWord(String[] words ,String input){
		return Arrays.stream(words).anyMatch(input::equals);
	}
}