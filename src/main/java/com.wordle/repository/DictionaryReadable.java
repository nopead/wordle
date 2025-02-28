package com.wordle.repository;

interface DictionaryReadable{
	
	int getDictionaryLength(int wordsLength);
	
	boolean isDictionaryContainsWord(String word);
	
	String getRandomDictionaryWord(int wordsLength);

}