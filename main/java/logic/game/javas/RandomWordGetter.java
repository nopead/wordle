package main.java.logic.game.classes;

import main.java.repository.classes.IDictionaryRepository;
import main.java.repository.classes.DictionaryRepositoryImpl;
import java.util.Random;

public class RandomWordGetter{
	public static String getRandomWord(){
		Random rnd = new Random();
		IDictionaryRepository reader = new DictionaryRepositoryImpl();
		String[] words = reader.getWords();
		return words[rnd.nextInt(0, words.length - 1)];
	}
}