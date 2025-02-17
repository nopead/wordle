package main.java.logic.classes;

import main.java.repository.classes.WordsFileReader;
import java.util.Set;

class UserWordOnExistChecker extends GameSession{
	boolean checkUserWordOnExist(String userWord){
		Set<String> words = WordsFileReader.getAllWords();
		return words.contains(userWord);
	}
}