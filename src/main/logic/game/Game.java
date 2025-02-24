package main.logic.game;

import main.logic.game.LetterStateWrapper;
import main.logic.game.RandomWordGetter;
import java.util.LinkedList;

public class Game{
	private int remainingAttemptsCount;
	private final String GUESS_WORD;
	private LinkedList<LetterStateWrapper> lettersStates;

	public Game(){
		GUESS_WORD = RandomWordGetter.getRandomWord();
		remainingAttemptsCount = 6;
		lettersStates = new LinkedList<LetterStateWrapper>();
	}
	
	public int getWordToGuessLength(){
		return GUESS_WORD.length();
	}
	
	public int getRemainingAttemptsCount(){
		return remainingAttemptsCount;
	}
	
	public LinkedList<LetterStateWrapper> getLettersStates(){
		return this.lettersStates;
	}
	
	public boolean compareWithSecret(String userWord){
		return userWord.equals(GUESS_WORD);
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
		for (int i = 0; i < GUESS_WORD.length(); i++){
			char currentLetter = userWord.charAt(i);
			if(!isLetterStated(currentLetter)){
				if (GUESS_WORD.indexOf(currentLetter) == -1){
					addLetterWithNotUsedState(currentLetter);
				}
				else if ((Character.compare(GUESS_WORD.charAt(i), currentLetter)) == 0){
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
	
	public String getGuessWord(){
		return this.GUESS_WORD;
	}
}