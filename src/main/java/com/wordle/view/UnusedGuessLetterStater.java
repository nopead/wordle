package com.wordle.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.wordle.view.GuessLetterStater;

public class UnusedGuessLetterStater extends GuessLetterStater {

    public UnusedGuessLetterStater() {
        letters = new HashSet<>();
    }

    @Override
    public List<Integer> getIndexes(String source, String compare) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            if (source.indexOf(compare.charAt(i)) == -1) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
