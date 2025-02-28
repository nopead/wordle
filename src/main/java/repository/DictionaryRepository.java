package main.java.repository;

public interface DictionaryRepository{
	
	int getDictionaryLength(int wordsLength);
	
	boolean isDictionaryContainsWord(String word);
	
	String getRandomWord(int wordLength);
	
}