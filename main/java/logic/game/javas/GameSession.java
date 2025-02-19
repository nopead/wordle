package main.java.logic.game.classes;

import main.java.logic.game.classes.LetterStateWrapper;
import main.java.logic.game.classes.RemainingAttemptsAnalyzer;
import main.java.logic.game.classes.RemainingAttemptsDecreaser;
import main.java.logic.game.classes.LettersStateManager;
import main.java.logic.game.classes.GuessWordLettersAnalyzer;
import main.java.logic.game.classes.GuessWordAnalyzer;
import main.java.logic.game.classes.RandomWordGetter;
import java.util.ArrayList;

public class GameSession{
	protected int attemptsRemaining;
	protected final String WORD_TO_GUESS;
	protected ArrayList<LetterStateWrapper> lettersStates;
	
	public RemainingAttemptsAnalyzer remainingAttemptsAnalyzer;
	public RemainingAttemptsDecreaser remainingAttemptsDecreaser;
	public LettersStateManager lettersStatesManager;
	public GuessWordLettersAnalyzer guessedWordLettersAnalyzer;
	public GuessWordAnalyzer guessWordAnalyzer;
	
	public GameSession(){
		WORD_TO_GUESS = RandomWordGetter.getRandomWord();
		attemptsRemaining = 5;
		initUtils();
	}
	
	private void initUtils(){
		remainingAttemptsAnalyzer = new RemainingAttemptsAnalyzer(this);
		remainingAttemptsDecreaser = new RemainingAttemptsDecreaser(this);
		lettersStatesManager = new LettersStateManager(this);
		guessedWordLettersAnalyzer = new GuessWordLettersAnalyzer(this.lettersStatesManager);
		guessWordAnalyzer = new GuessWordAnalyzer(this);
		lettersStates = new ArrayList<LetterStateWrapper>();
	}
	
	public ArrayList<LetterStateWrapper> getLettersStates(){
		return this.lettersStates;
	}
}