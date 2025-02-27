package main.repository;

import main.repository.IDictionaryReadable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.Strictness;
import java.util.Random;

public class JsonDictionaryReader implements IDictionaryReadable{
	private static final String filePath = System.getProperty("user.dir") + "/src/resources/";
	private static final String fileExctention = ".json";
	
	public String getRandomDictionaryWord(int dictionaryWordsLength){
		int pointer = 0;
		Random rnd = new Random();
		int randomWordIndex = rnd.nextInt(getDictionaryLength(dictionaryWordsLength));
		try (JsonReader dictionaryWordsReader = getDictionaryWordsArray(dictionaryWordsLength)){
			dictionaryWordsReader.beginArray();
			while(dictionaryWordsReader.hasNext()){
				if(pointer == randomWordIndex){
					return dictionaryWordsReader.nextString();
				}
				else{
					pointer++;
					dictionaryWordsReader.skipValue();
				}
				
			}
			dictionaryWordsReader.endArray();
		}catch (IOException e){
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean isDictionaryContainsWord(int dictionaryWordsLength, String word){
		int index = 0;
		try (JsonReader dictionaryWordsReader = getDictionaryWordsArray(dictionaryWordsLength)){
			dictionaryWordsReader.beginArray();
			while(dictionaryWordsReader.hasNext()){
				if(word.equals(dictionaryWordsReader.nextString())){
					dictionaryWordsReader.close();
					return true;
				}
				index++;
			}
			dictionaryWordsReader.endArray();
		}catch (IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public int getDictionaryLength(int dictionaryWordsLength){
		int count = 0;
		try (JsonReader dictionaryWordsReader = getDictionaryWordsArray(dictionaryWordsLength)){
			dictionaryWordsReader.beginArray();
			while(dictionaryWordsReader.hasNext()){
				dictionaryWordsReader.skipValue();
				count++;
			}
			dictionaryWordsReader.endArray();
		}catch (IOException e){
			e.printStackTrace();
		}
		return count;
	}
			
	private JsonReader getDictionaryWordsArray(int dictionaryWordsLength) throws IOException{
		try{
			JsonReader jsonReader = new JsonReader(new BufferedReader(new FileReader(filePath + "dcopy" + fileExctention)));
			jsonReader.setStrictness(Strictness.LENIENT);
			jsonReader.beginArray();
			while(jsonReader.hasNext()){
				jsonReader.beginObject();
				while(jsonReader.hasNext()){
					if(JsonToken.NAME.equals(jsonReader.peek()) && jsonReader.nextName().equals("words_length")){
						if(jsonReader.nextInt() == dictionaryWordsLength){
							while(!(JsonToken.BEGIN_ARRAY.equals(jsonReader.peek()))){
								jsonReader.skipValue();
							}
							return jsonReader;
						}
					}
					else{
						jsonReader.skipValue();
					}
				}
				jsonReader.endObject();
			}
			jsonReader.endArray();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return new JsonReader(new StringReader("[]"));
	}
}

