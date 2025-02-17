package main.java.logic.classes;

import main.java.repository.classes.WordsFileReader;
import main.java.logic.classes.GameSession;
import java.util.Set;

public class UserWordOnExistChecker{
	public static boolean check(String userWord){
		Set<String> words = WordsFileReader.getAllWords();
		return words.contains(userWord);
	}
}