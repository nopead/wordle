package com.wordle.repository;

public interface DictionaryRepository{
	
	int getDictionaryLength(int wordsLength);
	
	boolean isDictionaryContainsWord(String word);
	
	String getRandomWord(int wordLength);
	
}