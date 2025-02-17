package main.java.logic.classes;

import main.java.repository.classes.WordsFileReader;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

class RandomWordGetter{
	public static String getRandomWord(){
		Random rnd = new Random();
		Set<String> words = WordsFileReader.getAllWords();
		Iterator<String> iter = words.iterator();
		int randomWordIndex = rnd.nextInt(words.size());
		for(int i = 0; i < randomWordIndex; i++){
			iter.next();
		}
		return iter.next();
	}
}