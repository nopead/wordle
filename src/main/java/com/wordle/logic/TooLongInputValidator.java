package com.wordle.logic;

import com.wordle.logic.GuessValidationErrorMessage;
import com.wordle.logic.LengthValidator;

public class TooLongInputValidator extends LengthValidator {

    public TooLongInputValidator(int border) {
        if (border >= 0) {
            this.border = border;
        }
        else {
            throw new RuntimeException("border cannot be less than zero");
        }
    }

    @Override
    public boolean isValid(String input) {
        return input.length() <= border;
    }
    @Override
    public String getErrorMessage() {
        return GuessValidationErrorMessage.INPUT_TEXT_LENGTH_LONGER;
    }

}
