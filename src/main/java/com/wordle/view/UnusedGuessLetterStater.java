package com.wordle.view;

import java.util.HashSet;
import com.wordle.view.GuessLetterStater;

public class UnusedGuessLetterStater extends GuessLetterStater {

    private String guess;
    public UnusedGuessLetterStater() {
        letters = new HashSet<>();
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    @Override
    public String getStateType(){
        return "Unused letters";
    }

    @Override
    public void state(String guessResult){
        for (int i = 0; i < guessResult.length(); i++) {
            if (guessResult.charAt(i) == '*') {
                letters.add(guess.charAt(i));
            }
        }
    }

}
