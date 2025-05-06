package com.wordle.logic;

import java.util.regex.Pattern;
import com.wordle.logic.GuessValidator;

public abstract class PatternValidator implements GuessValidator {

    protected String pattern;

    @Override
    public boolean isValid(String input){
        return Pattern.compile(pattern).matcher(input).matches();
    }

}
