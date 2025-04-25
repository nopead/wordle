package com.wordle.repository;

public interface DictionaryRepository{
	
	void read(int wordsLength);
	
	boolean containsWord(String word);
	
	String getRandomWord();
	
}