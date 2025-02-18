package main.java.logic.classes;

import main.java.logic.classes.RandomWordGetter;
import main.java.logic.classes.LetterStateWrapper;
import java.util.ArrayList;


public class GameSession{
	
	protected int attemptsRemaining;
	protected final String HIDDEN_WORD;
	
	public ArrayList<LetterStateWrapper> lettersStates;
	
	public GameSession(){
		HIDDEN_WORD = RandomWordGetter.getRandomWord();
		System.out.println("Загаданное слово: " + HIDDEN_WORD);
		attemptsRemaining = 5;
		lettersStates = new ArrayList<LetterStateWrapper>();
	}
	
	public int getAttemptsRemaining(){
		return this.attemptsRemaining;
	}
	
	public ArrayList<LetterStateWrapper> getLetterStates(){
		return this.lettersStates;
	}
}