package com.wordle.logic;

public interface GuessValidator {

     boolean isValid(String input);

     String getErrorMessage();

}
