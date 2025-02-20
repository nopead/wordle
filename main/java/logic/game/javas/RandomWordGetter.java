package main.java.logic.game.classes;

import java.util.Random;
import main.java.logic.game.classes.DictionaryGetter;

public class RandomWordGetter{
	public static String getRandomWord(){
		Random rnd = new Random();
		String[] dictionary = DictionaryGetter.getDictionary();
		return dictionary[rnd.nextInt(0, dictionary.length - 1)];
	}
}