package main.repository;

import main.repository.IDictionaryRepository;
import main.repository.IDictionaryReadable;
import main.repository.JsonDictionaryReader;

public class DictionaryRepositoryImpl implements IDictionaryRepository{
	
	public int getDictionaryLength(int wordsLength){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		int dictionaryLength = dictionaryReader.getDictionaryLength(wordsLength);
		return dictionaryLength;
	}

}