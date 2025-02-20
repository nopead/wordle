package main.java.logic.game.classes;

import main.java.logic.game.classes.LetterStateWrapper;
import main.java.logic.game.classes.RandomWordGetter;
import java.util.ArrayList;

public class Game{
	private int remainingAttemptsCount;
	private final String WORD_TO_GUESS;
	private ArrayList<LetterStateWrapper> lettersStates;

	public Game(){
		WORD_TO_GUESS = RandomWordGetter.getRandomWord();
		remainingAttemptsCount = 6;
		lettersStates = new ArrayList<LetterStateWrapper>();
	}
	
	public int getRemainingAttemptsCount(){
		return remainingAttemptsCount;
	}
	
	public ArrayList<LetterStateWrapper> getLettersStates(){
		return this.lettersStates;
	}
	
	public boolean compareWithSecret(String userWord){
		return userWord.equals(WORD_TO_GUESS);
	}
	
	public boolean isAttemptsOver(){
		return (remainingAttemptsCount < 1);
	}
	
	private boolean isLetterStated(char letter){
		for (LetterStateWrapper letterState : lettersStates){
			if (Character.compare(letterState.getLetter(), letter) == 0){
				return true;
			}
		}
		return false;
	}
	
	public void decreaseRemainingAttemptsCount(){
		if (remainingAttemptsCount > 0){
			remainingAttemptsCount--;
		}
	}
	
	public void stateLetters(String userWord){
		for (int i = 0; i < WORD_TO_GUESS.length(); i++){
			char currentLetter = userWord.charAt(i);
			if(!isLetterStated(currentLetter)){
				if (WORD_TO_GUESS.indexOf(currentLetter) == -1){
					addLetterWithNotUsedState(currentLetter);
				}
				else if ((Character.compare(WORD_TO_GUESS.charAt(i), currentLetter)) == 0){
					addLetterWithRightPlaceState(currentLetter, i);
				}
				else {
					addLetterWithWrongPlaceState(currentLetter, i);
				}
			}
		}
	}
	
	private void addLetterWithRightPlaceState(char letter, int index){
		lettersStates.add(new LetterStateWrapper(letter, index, LetterState.RIGHT_PLACE));
	}
	
	private void addLetterWithWrongPlaceState(char letter, int index){
		lettersStates.add(new LetterStateWrapper(letter, index, LetterState.WRONG_PLACE));
	}
	
	private void addLetterWithNotUsedState(char letter){
		lettersStates.add(new LetterStateWrapper(letter));
	}
}