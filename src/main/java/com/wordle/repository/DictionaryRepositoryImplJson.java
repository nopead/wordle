package com.wordle.repository;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.JsonDictionaryReader;
import com.wordle.repository.DictionaryReadable;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class DictionaryRepositoryImplJson implements DictionaryRepository {
	
	private final static DictionaryReadable dictionaryReader = JsonDictionaryReader.getInstance();

	private String[] dictionary;
		
	public void read() {
		if (dictionary == null){
			try{
				dictionary = dictionaryReader.getDictionaryWords();
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