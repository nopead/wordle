package main.java.logic.game.classes;

import java.util.Arrays;

public class WordInDictionaryChecker{
	public static boolean isExists(String[] words, String userWord){
		return Arrays.stream(words).anyMatch(userWord::equals);
	}
}