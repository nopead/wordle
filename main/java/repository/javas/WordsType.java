package main.java.repository.classes;

import com.google.gson.annotations.SerializedName;
import java.util.Set;

class WordsType{
	@SerializedName("words")
	private Set<String> words;
	
	public Set<String> getWords(){
		return this.words;
	}
	
	public void setWords(Set<String> wordsArray){
		this.words = wordsArray;
	}
}