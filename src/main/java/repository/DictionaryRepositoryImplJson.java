package main.java.repository;

import main.repository.IDictionaryRepository;
import main.repository.IDictionaryReadable;
import main.repository.JsonDictionaryReader;
import java.util.Random;

public class DictionaryRepositoryImplJson implements IDictionaryRepository{
	
	public int getDictionaryLength(int wordsLength){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		int dictionaryLength = dictionaryReader.getDictionaryLength(wordsLength);
		return dictionaryLength;
	}
	
	public boolean isDictionaryContainsWord(String word){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.isDictionaryContainsWord(word);
	}
	
	public String getRandomWord(int wordLength){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.getRandomDictionaryWord(wordLength);
	}
}