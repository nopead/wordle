package main.java.repository.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import main.java.repository.classes.WordsType;
import com.google.gson.Gson;
import java.util.Collections;
import java.util.Set;

public class WordsFileReader{
	private static final String filePath = "main/resources/words.json";
	
	public static Set<String> getAllWords(){
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
		return Collections.<String>emptySet();
	}	
}