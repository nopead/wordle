package com.wordle.logic.validation;

import java.util.ArrayList;
import java.util.List;

import com.wordle.model.ValidateResultResponse;
import com.wordle.logic.validation.GuessValidator;
import com.wordle.logic.validation.LattinPatternValidator;
import com.wordle.logic.validation.TooLongInputValidator;
import com.wordle.logic.validation.TooShortInputValidator;
import com.wordle.logic.validation.GuessIsWordValidator;
import com.wordle.enums.ValidationError;
import com.wordle.config.Config;


public class ValidationGateway {

    private final List<GuessValidator> validators;
    private final List<ValidationError> errors;

    public ValidationGateway(Config config) {
        validators = List.of(
                new LattinPatternValidator(),
                new TooLongInputValidator(config.getWordsLength()),
                new TooShortInputValidator(config.getWordsLength()),
                new GuessIsWordValidator(config.getDictionaryRepository())
        );
        errors = new ArrayList<>();
    }

    public ValidateResultResponse validate(String word) {
        ValidateResultResponse response;
        for (GuessValidator validator : validators) {
            if (!validator.isValid(word)) {
                errors.add(validator.getError());
            }
        }
        response = new ValidateResultResponse(errors.isEmpty(), errors);
        clearErrors();
        return response;
    }

    public void clearErrors(){
        errors.clear();
    }
}
