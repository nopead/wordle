package com.wordle.logic.validation;

import com.wordle.enums.ValidationError;

public interface GuessValidator {

     boolean isValid(String input);

     ValidationError getError();

}
