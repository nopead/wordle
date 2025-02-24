package main.repository;

import main.repository.IDictionaryRepository;
import main.repository.IDictionaryReadable;
import main.repository.JsonDictionaryReader;

public class DictionaryRepositoryImpl implements IDictionaryRepository{
	public String[] getWords(){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.read();
	}
}