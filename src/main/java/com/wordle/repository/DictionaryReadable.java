package com.wordle.repository;

import java.io.IOException;
import java.util.List;

interface DictionaryReadable{
	
	List<String> getDictionaryWords() throws IOException;

}