package com.wordle.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.wordle.view.GuessLetterStater;
import com.wordle.view.WrongGuessLetterStater;

public class RightGuessLetterStater extends GuessLetterStater {

    WrongGuessLetterStater listener;

    public RightGuessLetterStater()
    {
        letters = new HashSet<>();
    }

    public void setListener(WrongGuessLetterStater listener){
        this.listener = listener;
    }

    @Override
    public String getStateType(){
        return "Right placed letters";
    }

    @Override
    public void state(String guessResult){
        for (char c : guessResult.toCharArray()) {
            if (Character.isUpperCase(c)){
                letters.add(Character.toLowerCase(c));
                listener.onRightLetterAdded(c);
            }
        }
    }

}
