package main.java.repository.classes;

import main.java.repository.classes.IDictionaryRepository;
import main.java.repository.classes.IDictionaryReadable;
import main.java.repository.classes.JsonDictionaryReader;

public class DictionaryRepositoryImpl implements IDictionaryRepository{
	public String[] getWords(){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.read();
	}
}