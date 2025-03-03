package com.wordle.repository;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryReadable;
import com.wordle.repository.JsonDictionaryReader;
import java.util.Random;
import java.util.Arrays;
import java.util.stream.Stream;
import java.io.IOException;

public class DictionaryRepositoryImplJson implements DictionaryRepository{
	
	private final static DictionaryReadable dictionaryReader = new JsonDictionaryReader();
	
	private String[] dictionary;
		
	public void readDictionary(int wordsLength){
		try{ 
			dictionary = dictionaryReader.getDictionaryWords(wordsLength);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
		
	public boolean isDictionaryContainsWord(String word){
		return Arrays.stream(dictionary).anyMatch(dictionaryWord -> (dictionaryWord.equals(word)));
	}
	
	public String getRandomWord(){
		Random rnd = new Random();
		return dictionary[rnd.nextInt(0, dictionary.length)];
	}
	
}