package main.java.repository.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class WordsType{
	@SerializedName("words")
	private String[] words;
	
	String[] getWords(){
		return this.words;
	}
	
	void setWords(String[] wordsArray){
		this.words = wordsArray;
	}
}

public class WordsFileReader{
	private static final String filePath = "main/resources/words.json";
	
	public static String[] getAllWords(){
		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			WordsType words = gson.fromJson(br, WordsType.class);
			return words.getWords();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return new String[] {};
	}	
}

