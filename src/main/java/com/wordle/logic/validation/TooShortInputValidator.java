package com.wordle.logic.validation;

import com.wordle.logic.validation.LengthValidator;
import com.wordle.enums.ValidationError;

public class TooShortInputValidator extends LengthValidator {

    public TooShortInputValidator(int border){
        if (border >= 0) {
            this.border = border;
        }
        else {
            throw new RuntimeException("border cannot be less than zero");
        }
    }

    @Override
    public boolean isValid(String input) {
        return input.length() >= border;
    }

    @Override
    public ValidationError getError() {
        return ValidationError.GUESS_TOO_SHORT;
    }

}
