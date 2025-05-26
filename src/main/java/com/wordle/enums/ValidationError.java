package com.wordle.enums;

public enum ValidationError {

    GUESS_TOO_SHORT(1, "Input word is too short"),
    GUESS_TOO_LONG(2, "Input word is too long"),
    GUESS_IS_NOT_WORD(3, "Input sequence is not word"),
    PATTERN_DOESNT_MATCH(4, "Input sequence doesnt match the pattern");

    int code;
    String description;

    ValidationError(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
 
}
