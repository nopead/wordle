package main.java.logic.classes;

import main.java.logic.classes.RandomWordGetter;
import main.java.logic.classes.LetterStateWrapper;
import main.java.logic.classes.RemainingAttemptsAnalyzer;
import main.java.logic.classes.RemainingAttemptsDecreaser;
import main.java.logic.classes.GuessLettersStateManager;
import main.java.logic.classes.GuessedLettersAnalyzer;
import main.java.logic.classes.GuessHandler;

import java.util.ArrayList;

public class GameSession{
	
	protected int attemptsRemaining;
	protected final String HIDDEN_WORD;
	
	public RemainingAttemptsAnalyzer attemptsAnalyzer;
	public RemainingAttemptsDecreaser remainingAttemptsDecreaser;
	public GuessLettersStateManager lettersStatesManager;
	public GuessHandler guessHandler;
	public GuessedLettersAnalyzer guessedLettersAnalyzer;
	
	public ArrayList<LetterStateWrapper> lettersStates;
	
	public GameSession(){
		HIDDEN_WORD = RandomWordGetter.getRandomWord();
		attemptsRemaining = 5;
		initUtils();
	}
	
	private void initUtils(){
		attemptsAnalyzer = new RemainingAttemptsAnalyzer(this);
		remainingAttemptsDecreaser = new RemainingAttemptsDecreaser(this);
		lettersStatesManager = new GuessLettersStateManager(this);
		guessedLettersAnalyzer = new GuessedLettersAnalyzer(this);
		guessHandler = new GuessHandler(this.lettersStatesManager);
		lettersStates = new ArrayList<LetterStateWrapper>();
	}
	
	public int getAttemptsRemaining(){
		return this.attemptsRemaining;
	}
	
	public ArrayList<LetterStateWrapper> getLetterStates(){
		return this.lettersStates;
	}
	
	public String getHiddenWord(){
		return this.HIDDEN_WORD;
	}
}