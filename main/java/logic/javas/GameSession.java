package main.java.logic.classes;

import main.java.logic.RandomWordGetter;
import main.java.logic.LetterState;
import java.util.HashMap;

class GameSession{
	
	protected int attemptsRemainig;
	private final String HIDDEN_WORD;
	
	HashMap<String, LetterState> lettersStates;
	
	GameSession(){
		HIDDEN_WORD = RandomWordGetter.getRandomWord();
		attemptsRemainig = 6;
		lettersStates = new HashMap<String, LetterState>();
	}
}