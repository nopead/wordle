package com.wordle.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.wordle.repository.DictionaryReadable;

public class JSONDictionaryReader implements DictionaryReadable{

	private final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/";
	private final String DICTIONARY_FILENAME = "dictionaries.json";

	private static com.wordle.repository.JSONDictionaryReader instance;

	private JSONDictionaryReader() {}

	public static JSONDictionaryReader getInstance() {
		if (instance == null) {
			instance = new com.wordle.repository.JSONDictionaryReader();
		}
		return instance;
	}

	public List<String> getDictionaryWords() throws IOException {
		List<String> words;
		ObjectMapper objectMapper = new ObjectMapper();
		words = objectMapper.readValue(new FileInputStream(RESOURCES_PATH + DICTIONARY_FILENAME), new TypeReference<List<String>>() {});
		return words;
	}
	
}