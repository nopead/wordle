package main.repository;

import main.repository.IDictionaryReadable;
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

public class JsonDictionaryReader implements IDictionaryReadable{
	private static final String filePath = System.getProperty("user.dir") + "/src/resources/words.json";
	
	public String[] read(){
		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			WordsType words = gson.fromJson(br, WordsType.class);
			return words.getWords();
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
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

