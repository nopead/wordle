package com.wordle.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryReadable;
import com.wordle.repository.JSONDictionaryReader;

public class DictionaryRepositoryImplJSON implements DictionaryRepository {
	
	private final static DictionaryReadable dictionaryReader = JSONDictionaryReader.getInstance();

	private List<String> dictionary;
		
	public void read() {
		if (dictionary == null) {
			try {
				dictionary = dictionaryReader.getDictionaryWords();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public boolean containsWord(String word) {
		if (dictionary == null) {
			read();
		}
		return dictionary.contains(word);
	}
	
	public String getRandomWord() {
		if (dictionary == null) {
			read();
		}
		return dictionary.get(new Random().nextInt(dictionary.size()));
	}
	
}