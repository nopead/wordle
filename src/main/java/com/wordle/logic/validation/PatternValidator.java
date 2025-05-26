package com.wordle.logic.validation;

import com.wordle.logic.validation.GuessValidator;
import java.util.regex.Pattern;
import com.wordle.enums.ValidationError;

public abstract class PatternValidator implements GuessValidator {

    protected String pattern;

    @Override
    public boolean isValid(String input){
        return Pattern.compile(pattern).matcher(input).matches();
    }

    @Override
    public ValidationError getError() {
        return ValidationError.PATTERN_DOESNT_MATCH;
    }

}
