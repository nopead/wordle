package test;

import main.repository.IDictionaryRepository;
import main.repository.DictionaryRepositoryImpl;

class TestJsonReader{
	public static void main(String[] args){
		IDictionaryRepository reader = new DictionaryRepositoryImpl();
		System.out.println(reader.getDictionaryLength(5));
	}
}