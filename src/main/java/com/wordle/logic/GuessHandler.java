package com.wordle.logic;

import com.wordle.logic.util.StringLettersCounter;
import java.util.Arrays;
import java.util.Map;

public class GuessHandler {

    private final String hidden;

    public GuessHandler(String hidden) {
        this.hidden = hidden;
    }

    public String compareWithSecret(String guess){
        Map<Character, Integer> lettersCountsInHiddenWord = StringLettersCounter.calcucate(hidden);
        char[] result = new char[hidden.length()];
        Arrays.fill(result, '*');

        for (int i = 0; i < guess.length(); i++) {
            char guessedChar = guess.charAt(i);
            if (guessedChar == hidden.charAt(i)) {
                result[i] = Character.toUpperCase(guessedChar);
                lettersCountsInHiddenWord.put(guessedChar, lettersCountsInHiddenWord.get(guessedChar) - 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char guessedChar = guess.charAt(i);
            if (result[i] == '*' && lettersCountsInHiddenWord.getOrDefault(guessedChar, 0) > 0) {
                result[i] = Character.toLowerCase(guessedChar);
                lettersCountsInHiddenWord.put(guessedChar, lettersCountsInHiddenWord.get(guessedChar) - 1);
            }
        }

        return new String(result);
    }

}
