package main.repository;

import main.repository.IDictionaryReadable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

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
	private static final String filePath = System.getProperty("user.dir") + "/src/resources/";
	private static final String fileExctention = ".json";
		
	//Потом поменять на private и использовать в методе получения случ слова;	
	public int getDictionaryLength(int wordsLength){
		JsonObject dictionaryElement = getDictionaryElementByLength(wordsLength);
		return dictionaryElement.getAsJsonObject().get("count").getAsInt();
	}
	//Дописать
	public String[] getDictionaryWords(int wordsLength){
		JsonObject dictionaryElement = getDictionaryElementByLength(wordsLength);
		return new String[]{};
	}
	
	private int getDictionaryWordsLength(JsonReader dictionaryElementReader){
		JsonObject dictionaryObject = JsonParser.parseReader​(dictionaryElementReader).getAsJsonObject();
		return dictionaryObject.get("length").getAsInt();
	}
	
	private JsonObject getDictionaryElementByLength(int length){
		try (JsonReader jsonReader = new JsonReader(new BufferedReader(new FileReader(filePath + "words" + fileExctention)))){
			jsonReader.beginArray();
			while(jsonReader.hasNext()){
				//Проверить что возвращет метод
				if(getDictionaryWordsLength(jsonReader) == length){
					return JsonParser.parseReader​(jsonReader).getAsJsonObject();
				}				
			}
			jsonReader.endArray();
		} catch (IOException e){
			System.out.println("Общий catch");
			e.printStackTrace();
		}
		return JsonParser.parseString("{ \"length\":0, \"count\":0, \"words\": [] }").getAsJsonObject();
	}
}

