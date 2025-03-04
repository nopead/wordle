package com.wordle.repository;

import java.io.IOException;

interface DictionaryReadable{
	
	String[] getDictionaryWords(int dictionaryWordsLength) throws IOException;

}