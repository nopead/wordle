package com.wordle.view;

import java.util.List;
import java.util.Set;

public abstract class GuessLetterStater {

    protected Set<Character> letters;

    public abstract List<Integer> getIndexes(String source, String compare);

    public void state(String source, String compare) {
        for (Integer index : getIndexes(source, compare)) {
            letters.add(compare.charAt(index));
        }
    }

    public Set<Character> returnStated() {
        return letters;
    }

    public void clear() {
        letters.clear();
    }

}
