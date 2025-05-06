package com.wordle.logic;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryRepositoryImplJson;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.wordle.logic.GuessValidator;
import com.wordle.logic.Game;
import com.wordle.logic.LattinPatternValidator;
import com.wordle.logic.GuessIsWordValidator;
import com.wordle.logic.TooLongInputValidator;
import com.wordle.logic.TooShortInputValidator;
import logic.RecordAttemptResponse;
import logic.ValidateResult;

public class GameManager {


    private final List<GuessValidator> guessValidators;

    private Game game;
    private final DictionaryRepository dictionaryRepository;

    public GameManager() {
        dictionaryRepository = new DictionaryRepositoryImplJson();
        dictionaryRepository.read();
        guessValidators = new ArrayList<>(List.of(
                new LattinPatternValidator(),
                new TooLongInputValidator(Game.WORDS_LENGTH),
                new TooShortInputValidator(Game.WORDS_LENGTH),
                new GuessIsWordValidator(dictionaryRepository)
        ));
    }

    public void startNewGame() {
        game = new Game(dictionaryRepository.getRandomWord());
    }

    private Map<Character, Integer> calculateLettersCountInWord(String word){
        Map<Character, Integer> lettersCountInWord = new HashMap<>();
        for (char c : word.toCharArray()) {
            lettersCountInWord.put(c, lettersCountInWord.getOrDefault(c, 0) + 1);
        }
        return lettersCountInWord;
    }

    private String createAttemptResponse() {
        String guess = game.getAttempts().getLast().getGuess();
        String hiddenWord = game.getHiddenWord();
        Map<Character, Integer> lettersCountsInHiddenWord = calculateLettersCountInWord(hiddenWord);
        char[] result = new char[hiddenWord.length()];
        Arrays.fill(result, '*');

        for (int i = 0; i < guess.length(); i++) {
            char guessedChar = guess.charAt(i);
            if (guessedChar == hiddenWord.charAt(i)) {
                result[i] = Character.toUpperCase(guessedChar);
                lettersCountsInHiddenWord.put(guessedChar, lettersCountsInHiddenWord.get(guessedChar) - 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char guessedChar = guess.charAt(i);
            if (result[i] == '*' && lettersCountsInHiddenWord.getOrDefault(guessedChar, 0) > 0) {
                result[i] = Character.toLowerCase(guessedChar);
                lettersCountsInHiddenWord.put(guessedChar, lettersCountsInHiddenWord.get(guessedChar) - 1);
            }
        }

        return new String(result);
    }

    public ValidateResult validateGuess(String guess) {
        for (GuessValidator validator : guessValidators) {
            if (!validator.isValid(guess)) {
                return new ValidateResult(false, validator.getErrorMessage());
            }
        }
        return new ValidateResult(true, "");
    }

    public RecordAttemptResponse tryRecordAttempt(String guess) {
        if (game != null) {
            ValidateResult result = validateGuess(guess);
            if (result.isValid()) {
                game.recordAttempt(guess);
                return new RecordAttemptResponse(true, createAttemptResponse());
            }
            else return new RecordAttemptResponse(false, result.getValidationErrorMessage());
        }
        else {
            return new RecordAttemptResponse(false, "No game is running");
        }
    }

    public int getRemainingAttemptsCount() {
        return Game.ALLOWED_ATTEMPTS_COUNT - game.getAttempts().size();
    }

    public String getHiddenWord() {
        return game.getHiddenWord();
    }

    public boolean isGameOver() {
        return isAttemptsOver() || isGuessed();
    }

    public boolean isAttemptsOver() {
       return game.getAttempts().size() >= Game.ALLOWED_ATTEMPTS_COUNT;
    }

    public boolean isGuessed() {
        if (!game.getAttempts().isEmpty()){
            return game.getHiddenWord().equals(game.getAttempts().getLast().getGuess());
        } else return false;
    }

}
