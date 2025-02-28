package main.java.repository;

import main.java.repository.DictionaryRepository;
import main.java.repository.DictionaryReadable;
import main.java.repository.JsonDictionaryReader;
import java.util.Random;

public class DictionaryRepositoryImplJson implements DictionaryRepository{
	
	public int getDictionaryLength(int wordsLength){
		DictionaryReadable dictionaryReader = new JsonDictionaryReader();
		int dictionaryLength = dictionaryReader.getDictionaryLength(wordsLength);
		return dictionaryLength;
	}
	
	public boolean isDictionaryContainsWord(String word){
		DictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.isDictionaryContainsWord(word);
	}
	
	public String getRandomWord(int wordLength){
		DictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.getRandomDictionaryWord(wordLength);
	}
	
}