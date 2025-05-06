package com.wordle.repository;

public interface DictionaryRepository{
	
	void read();
	
	boolean containsWord(String word);
	
	String getRandomWord();
	
}