package main.logic.game;

import main.logic.game.LetterState;
import main.logic.game.RandomWordGetter;
import java.util.LinkedList;

public class Game{
	
	protected int attemptsCount;
	protected int usedAttemptsCount;
	private final String HIDDEN_WORD;
	private LinkedList<String> guessWords;
	private LinkedList<String> guessStates;
	private HashMap<Character, LetterState> lettersStates;
	
	public Game(){
		HIDDEN_WORD = RandomWordGetter.getRandomWord();
		remainintAttemptsCount = 6;
		usedAttemptsCount = 0;
		guessWords = new LinkedList<String>();
		guessStates = new LinkedList<String>();
		lettersStates = new LinkedList<LetterStateWrapper>();		
	}
	
	public void getAttemptsCount(){
		return this.attemptsCount;
	}
	
	public void getUsedAttemptsCount(){
		return this.usedAttemptsCount;
	}
	
	public int getWordToGuessLength(){
		return HIDDEN_WORD.length();
	}
	
	public void setUsedAttemptsCount(int newValue){
		usedAttemptsCount = newValue();
	}
	
	public void setNewGuess(String guessWord){
		guessWords.addLast(guessWord);
	}
	
	public void setNewGuessState(String guessState){
		guessStates.addLast(guessState);
	}
		
	public HashMap<Character, LetterState> getLettersStates(){
		return this.lettersStates;
	}
	
	public String getHiddenWord(){
		return this.HIDDEN_WORD;
	}
}