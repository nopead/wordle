package com.wordle.view;

import java.util.List;
import java.util.Set;

public abstract class GuessLetterStater {

    protected Set<Character> letters;

    public abstract void state(String guessResult);
    public abstract String getStateType();

    public Set<Character> returnStated() {
        return letters;
    }

    public void clear() {
        letters.clear();
    }

}
