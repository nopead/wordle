package main.java.logic.game.classes;

import main.java.repository.classes.IDictionaryRepository;
import main.java.repository.classes.DictionaryRepositoryImpl;

public class DictionaryGetter{
	public static String[] getDictionary(){
		IDictionaryRepository reader = new DictionaryRepositoryImpl();
		return reader.getWords();
	}
}