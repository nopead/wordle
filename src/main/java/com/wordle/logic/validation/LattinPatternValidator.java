package logic.validation;

public class LattinPatternValidator extends PatternValidator {

    public LattinPatternValidator() {
        pattern = "^[a-z]*";
    }

    @Override
    public String getErrorMessage() {
        return GuessValidationErrorMessage.ONLY_LATIN_LETTERS_REQUIRED;
    }

}
