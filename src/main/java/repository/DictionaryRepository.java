package main.java.repository;

public interface DictionaryRepository{
	
	public int getDictionaryLength(int wordsLength);
	
	public boolean isDictionaryContainsWord(String word);
	
	public String getRandomWord(int wordLength);
	
}