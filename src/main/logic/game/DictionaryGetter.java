package main.logic.game;

import main.repository.IDictionaryRepository;
import main.repository.DictionaryRepositoryImpl;

public class DictionaryGetter{
	public static String[] getDictionary(){
		IDictionaryRepository reader = new DictionaryRepositoryImpl();
		return reader.getWords();
	}
}