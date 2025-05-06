package com.wordle.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.wordle.repository.DictionaryReadable;

public class JsonDictionaryReader implements DictionaryReadable{

	private final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/";
	private final String DICTIONARY_FILENAME = "dictionaries.json";

	private static JsonDictionaryReader instance;

	private JsonDictionaryReader() {}

	public static JsonDictionaryReader getInstance() {
		if (instance == null) {
			instance = new JsonDictionaryReader();
		}
		return instance;
	}

	public String[] getDictionaryWords() throws IOException {
		List<String> words = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		words = objectMapper.readValue(new FileInputStream(RESOURCES_PATH + DICTIONARY_FILENAME), new TypeReference<ArrayList<String>>() {});
		return words.toArray(new String[0]);
	}
	
}