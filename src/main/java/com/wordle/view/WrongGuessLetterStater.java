package com.wordle.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.wordle.view.GuessLetterStater;
import com.wordle.view.RightGuessLetterStater;

public class WrongGuessLetterStater extends GuessLetterStater {

    RightGuessLetterStater tracked;

    public WrongGuessLetterStater(RightGuessLetterStater tracked) {
        letters = new HashSet<>();
        this.tracked = tracked;
        tracked.setListener(this);
    }

    public void onRightLetterAdded(Character c){
        letters.remove(c);
    }

    @Override
    public String getStateType(){
        return "Wrong placed letters";
    }

    @Override
    public void state(String guessResult){
        for (char c : guessResult.toCharArray()) {
            if (Character.isLowerCase(c) && !tracked.returnStated().contains(c)) {
                letters.add(c);
            }
        }
    }

}
