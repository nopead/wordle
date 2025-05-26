package com.wordle.logic.util;

import java.util.Map;
import java.util.HashMap;

public class StringLettersCounter {

    public static Map<Character, Integer> calcucate(String word){
        Map<Character, Integer> lettersCountInWord = new HashMap<>();
        for (char c : word.toCharArray()) {
            lettersCountInWord.put(c, lettersCountInWord.getOrDefault(c, 0) + 1);
        }
        return lettersCountInWord;
    }

}
