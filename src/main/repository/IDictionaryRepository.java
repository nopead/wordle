package main.repository;

public interface IDictionaryRepository{
	
	public int getDictionaryLength(int wordsLength);
	
	public boolean isDictionaryContainsWord(int wordsLength, String word);
	
	public String getRandomWord(int wordLength);
	
}