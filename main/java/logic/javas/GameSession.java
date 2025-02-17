package main.java.logic.classes;

import main.java.logic.classes.RandomWordGetter;
import main.java.logic.classes.LetterState;
import java.util.HashMap;


public class GameSession{
	
	protected int attemptsRemaining;
	protected final String HIDDEN_WORD;
	
	public HashMap<Character, LetterState> lettersStates;
	
	public GameSession(){
		HIDDEN_WORD = RandomWordGetter.getRandomWord();
		System.out.println("Загаданное слово: " + HIDDEN_WORD);
		attemptsRemaining = 5;
		lettersStates = new HashMap<Character, LetterState>();
	}
	
	public int getAttemptsRemaining(){
		return this.attemptsRemaining;
	}
	
	public HashMap<Character, LetterState> getLetterStates(){
		return this.lettersStates;
	}
}