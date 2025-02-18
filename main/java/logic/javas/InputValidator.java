package main.java.logic.classes;

import main.java.repository.classes.WordsFileReader;
import java.util.Set;

public class InputValidator{
	
	public static boolean isMatch(String input){
		return false;
	}
	
	public static boolean isWord(String input){
		Set<String> words = WordsFileReader.getAllWords();
		return words.contains(input);
	}
}