package com.wordle.repository;

public interface DictionaryRepository{
	
	void readDictionary(int wordsLength);
	
	boolean isDictionaryContainsWord(String word);
	
	String getRandomWord();
	
}