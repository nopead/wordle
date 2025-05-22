package logic.validation;

public class GuessValidationErrorMessage {

    public static final String SEQUENCE_IS_NOT_WORD = "Input sequence is not a word";

    public static final String INPUT_TEXT_LENGTH_SHORTER = "Input word length are smaller than hidden";

    public static final String INPUT_TEXT_LENGTH_LONGER = "Input word length are bigger than hidden";

    public static final String ONLY_LATIN_LETTERS_REQUIRED = "You must use combination that consist only from lattin letters.";

    private GuessValidationErrorMessage() {}

}
