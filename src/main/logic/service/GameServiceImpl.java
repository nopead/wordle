package main.logic.service;

import main.logic.service.IGameService;
import main.logic.game.Game;
import main.logic.game.WordInDictionaryChecker;
import main.logic.game.DictionaryGetter;
import main.logic.game.LetterState;
import main.logic.game.LetterStateWrapper;
import java.util.LinkedList;
import java.util.Arrays;

public class GameServiceImpl implements IGameService{
	
	private Game game;
	
	public GameServiceImpl(){
		game = new Game();
	}
	
	public boolean isAttemptsOver(){
		return game.getUsedAttemptsCount() >= game.getAttemptsCount();
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return guessWord.equals(game.getHiddenWord());
	}
	
	public boolean isUserInputIsWord(String input){
		String[] dictionary = DictionaryGetter.getDictionary();
		return WordInDictionaryChecker.isExists(dictionary, input);
	}
	
	private void stateWrongPlacedLetter(char letter){
		HashMap letterStates = game.getLettersStates();
		if (!letterStates.containsKey(letter)){
			letterStates.put(letter, LetterState.WRONG_PLACE);
		}
	}
	
	private void stateRightPlacedLetter(char letter){
		HashMap letterStates = game.getLettersStates();
		if(!letterStates.containsKey(letter)){
			letterStates.put(letter, LetterState.RIGHT_PLACE);
		}
		else{
			if(!letterStates.get(letter) == LetterState.RIGHT_PLACE){
				letterStates.replace(letter, LetterState.RIGHT_PLACE);
			}
		}
	}
	
	public void stateGuessedLetters(String guessState){
		for (int i = 0; i < guessState.length(); i++){
			char currentLetter = guessState.charAt(i);
			if(!currentLetter.equals('*')){
				if(currentLetter.isLowerCase()){
					stateWrongPlacedLetter(currentLetter);
				}
				else{
					stateRightPlacedLetter(currentLetter);
				}
			}
		}
	}
	
	public String getLettersOnRightPlaces(){
		String rightPlacedLetters = "";
		return rightPlacedLetters;
	}
	
	public String getLettersOnWrongPlaces(){
		String wrongPlacedLetters = "";
		return wrongPlacedLetters;
	}
	
	public String getLettersThatWordNotContains(){
		String notUsedLetters = "";
		//переписать на hashmap
		return notUsedLetters;
	}
	
	public void decreaseRemainingAttemptsCount(){
		game.setUsedAttemptsCount(getUsedAttemptsCount() + 1);
	}
	
	public int getRemainingAttemptsCount(){
		return game.getAttemptsCount() - game.getUsedAttemptsCount();
	}
	
	public String getGuessWord(){
		return game.getGuessWord();
	}
}