package main.java.logic.game.classes;

import main.java.logic.game.classes.LetterStateWrapper;
import main.java.logic.game.classes.RemainingAttemptsAnalyzer;
import main.java.logic.game.classes.RemainingAttemptsDecreaser;
import main.java.logic.game.classes.LettersStateManager;
import main.java.logic.game.classes.GuessedLettersCounter;
import main.java.logic.game.classes.GuessWordLettersAnalyzer;
import main.java.logic.game.classes.GuessWordAnalyzer;
import main.java.logic.game.classes.RandomWordGetter;
import java.util.ArrayList;

class GameSession{
	protected int attemptsRemaining;
	protected final String WORD_TO_GUESS;
	protected ArrayList<LetterStateWrapper> lettersStates;
	
	private RemainingAttemptsAnalyzer attemptsAnalyzer;
	private RemainingAttemptsDecreaser remainingAttemptsDecreaser;
	private LettersStateManager lettersStatesManager;
	private GuessWordLettersAnalyzer guessedWordLettersAnalyzer;
	private GuessedLettersCounter guessedLettersCounter;
	private GuessWordAnalyzer guessWordAnalyzer;
	
	public GameSession(){
		WORD_TO_GUESS = RandomWordGetter.getRandomWord();
		attemptsRemaining = 5;
		initUtils();
	}
	
	private void initUtils(){
		attemptsAnalyzer = new RemainingAttemptsAnalyzer(this);
		remainingAttemptsDecreaser = new RemainingAttemptsDecreaser(this);
		lettersStatesManager = new LettersStateManager(this);
		guessedLettersCounter = new GuessedLettersCounter(this);
		GuessWordLettersAnalyzer guessedWordLettersAnalyzer = new GuessWordLettersAnalyzer(this.lettersStatesManager);
		guessWordAnalyzer = new GuessWordAnalyzer(this);
		lettersStates = new ArrayList<LetterStateWrapper>();
	}
	
	public ArrayList<LetterStateWrapper> getLettersStates(){
		return this.lettersStates;
	}
}