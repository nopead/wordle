package main.java.logic.game.classes;

import java.util.Arrays;

public class WordInDictionaryChecker{
	public static boolean isExists(String[] dictionary, String userWord){
		return Arrays.stream(dictionary).anyMatch(userWord::equals);
	}
}