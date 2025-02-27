package main.repository;

interface IDictionaryReadable{
	
	public int getDictionaryLength(int wordsLength);
	
	public boolean isDictionaryContainsWord(int wordsLength, String word);
	
	public String getRandomDictionaryWord(int wordsLength);

}