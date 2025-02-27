package main.repository;

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
	
	public boolean isDictionaryContainsWord(int wordsLength, String word){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.isDictionaryContainsWord(wordsLength, word);
	}
	
	public String getRandomWord(int wordLength){
		IDictionaryReadable dictionaryReader = new JsonDictionaryReader();
		return dictionaryReader.getRandomDictionaryWord(wordLength);
	}
}