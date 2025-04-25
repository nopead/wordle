package com.wordle.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.wordle.view.GuessLetterStater;

public class RightGuessLetterStater extends GuessLetterStater {

    public RightGuessLetterStater(){
        letters = new HashSet<>();
    }

    @Override
    public List<Integer> getIndexes(String source, String compare) {
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == compare.charAt(i)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
