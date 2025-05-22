package logic.validation;

import com.wordle.repository.DictionaryRepository;

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
