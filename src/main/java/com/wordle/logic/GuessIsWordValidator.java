package com.wordle.logic;

import com.wordle.repository.DictionaryRepository;
import com.wordle.logic.GuessValidator;
import com.wordle.logic.GuessValidationErrorMessage;

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
    public String getErrorMessage() {
        return GuessValidationErrorMessage.SEQUENCE_IS_NOT_WORD;
    }
}
