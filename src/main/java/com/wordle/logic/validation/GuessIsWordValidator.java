package com.wordle.logic.validation;

import com.wordle.repository.DictionaryRepository;
import com.wordle.logic.validation.GuessValidator;
import com.wordle.enums.ValidationError;

public class GuessIsWordValidator implements GuessValidator {

    DictionaryRepository dictionaryRepository;

    public GuessIsWordValidator(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public boolean isValid(String input) {
        return dictionaryRepository.containsWord(input);
    }

    @Override
    public ValidationError getError() {
        return ValidationError.GUESS_IS_NOT_WORD;
    }

}
