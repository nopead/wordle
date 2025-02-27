package main.java.repository;

interface DictionaryReadable{
	
	public int getDictionaryLength(int wordsLength);
	
	public boolean isDictionaryContainsWord(String word);
	
	public String getRandomDictionaryWord(int wordsLength);

}