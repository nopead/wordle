package main.java.logic.classes;

import main.java.repository.classes.WordsFileReader;
import java.util.Random;

public class RandomWordGetter{
	public static String getRandomWord(){
		Random rnd = new Random();
		String[] words = WordsFileReader.getAllWords();
		return words[rnd.nextInt(0, words.length - 1)];
	}
}