package com.wordle.logic.validation;

import com.wordle.logic.validation.PatternValidator;

public class LattinPatternValidator extends PatternValidator {

    public LattinPatternValidator() {
        pattern = "^[a-z]*";
    }

}
