package com.wordle.repository;

import com.wordle.repository.DictionaryReadable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;
import java.util.ArrayList;

public class JsonDictionaryReader implements DictionaryReadable{
	
	private static final String filePath = System.getProperty("user.dir") + "/src/main/resources/";
	private static final String fileExtention = ".json";
	
	public String[] getDictionaryWords(int dictionaryWordsLength) throws IOException{
		JsonFactory jsonFactory = new JsonFactory();
		try (JsonParser parser = jsonFactory.createJsonParser(new BufferedReader(new FileReader(filePath + "dictionaries" + fileExtention)))){
			while(!parser.isClosed()){
				JsonToken currentToken = parser.currentToken();
				if (JsonToken.FIELD_NAME.equals(currentToken) && parser.getCurrentName().equals("words_length") && parser.nextIntValue(-1) == dictionaryWordsLength){
					while(!(JsonToken.START_ARRAY.equals(parser.currentToken()))){
						parser.nextToken();
					}
					parser.nextToken();
					List<String> dictionaryWords = new ArrayList<>();
					while(!(JsonToken.END_ARRAY.equals(parser.currentToken()))){
						dictionaryWords.add(parser.getValueAsString());
						parser.nextToken();
					}
					parser.close();
					return dictionaryWords.toArray(new String[0]);
				} 
				parser.nextToken();
			}
		}
		return new String[0];
	}
	
}