package main.java.com.wordle.logic;

import com.wordle.config.GameConfig;
import com.wordle.logic.Game;
import com.wordle.logic.GuessValidator;
import com.wordle.logic.GuessIsWordValidator;
import com.wordle.logic.LattinPatternValidator;
import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryRepositoryImplJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.wordle.logic.TooLongInputValidator;
import com.wordle.logic.TooShortInputValidator;
import com.wordle.logic.GuessIsWordValidator;

public class GameManager {

    private Game game;
    private final GameConfig gameConfig = new GameConfig();
    private final List<GuessValidator> guessValidators;

    private DictionaryRepository dictionaryRepository;

    public GameManager() {
        dictionaryRepository = new DictionaryRepositoryImplJson();
        guessValidators = new ArrayList<>();
        initGuessValidators();
    }

    private void initGuessValidators() {
        guessValidators.add(new LattinPatternValidator());
        guessValidators.add(new GuessIsWordValidator(dictionaryRepository));
        guessValidators.add(new TooLongInputValidator(gameConfig.getWordsLength()));
        guessValidators.add(new TooShortInputValidator(gameConfig.getWordsLength()));
    }

    public void startNewGame() {
        game = new Game(dictionaryRepository.getRandomWord(), gameConfig.getAttemptsCount());
    }

    private String createAttemptResponse() {
        List<Character> resultLetters = new ArrayList<>();
        String guess = game.getAttempts().getLast().getGuess();
        String hiddenWord = game.getHiddenWord();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == hiddenWord.charAt(i)) {
                resultLetters.add(Character.toUpperCase(guess.charAt(i)));
            }
            else if (hiddenWord.indexOf(guess.charAt(i)) != -1) {
                resultLetters.add(guess.charAt(i));
            }
            else resultLetters.add('*');
        }
        return resultLetters.toString();
    }

    public String recordAttempt(String guess) {
        if (game != null) {
            for (GuessValidator validator : guessValidators) {
                if (!validator.isValid(guess)) {
                    return validator.getErrorMessage();
                }
            }
            game.recordAttempt(guess);
        }
        else {
            return "No game is running";
        }
        return createAttemptResponse();
    }

    public boolean isAttemptsOver() {
        return game.isAttemptsOver();
    }

    public boolean isGuessed() {
        return game.isGuessWordIsAnswer();
    }

}
