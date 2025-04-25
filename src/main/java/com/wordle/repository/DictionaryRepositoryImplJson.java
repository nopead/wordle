package com.wordle.repository;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryReadable;
import com.wordle.repository.JsonDictionaryReader;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Arrays;
import java.io.IOException;

public class DictionaryRepositoryImplJson implements DictionaryRepository{
	
	private final static DictionaryReadable dictionaryReader = JsonDictionaryReader.getInstance();

	private String[] dictionary;
		
	public void read(int wordsLength) {
		if (dictionary == null || dictionary[0].length() != wordsLength){
			try{
				dictionary = dictionaryReader.getDictionaryWords(wordsLength);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public boolean containsWord(String word){
		return Arrays.asList(dictionary).contains(word);
	}
	
	public String getRandomWord(){
		if (dictionary.length > 0) {
			return dictionary[new Random().nextInt(0, dictionary.length)];
		}
		else throw new NoSuchElementException("Empty dict");
	}
	
}