package main.logic.service;

import main.logic.service.IGameService;
import main.logic.game.Game;
import main.logic.game.WordInDictionaryChecker;
import main.logic.game.DictionaryGetter;
import main.logic.game.LetterState;
import main.logic.game.LetterStateWrapper;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;

public class GameServiceImpl implements IGameService{
	
	private Game game;
	
	public GameServiceImpl(){
		game = new Game();
	}
	
	public boolean isAttemptsOver(){
		return game.isAttemptsOver();
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return game.compareWithSecret(guessWord);
	}
	
	public boolean isUserInputIsWord(String input){
		String[] dictionary = DictionaryGetter.getDictionary();
		return WordInDictionaryChecker.isExists(dictionary, input);
	}
	
	private HashMap<Character, Integer> getLettersWithState(LetterState state){
		HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
		LinkedList<LetterStateWrapper> letterStates = game.getLettersStates();
		for (LetterStateWrapper letterState : letterStates){
			if (letterState.getState() == state){
				letters.put(letterState.getLetter(), letterState.getIndex());
			}
		}
		return letters;
	}
	
	private HashMap<Character, Integer> getLettersOnRigthPlaces(){
		return getLettersWithState(LetterState.RIGHT_PLACE);
	}
	
	private HashMap<Character, Integer> getLettersOnWrongPlaces(){
		
		return getLettersWithState(LetterState.WRONG_PLACE);
	}
	
	public String getCurrentGuessedState(){
		char[] letters = new char[game.getWordToGuessLength()];
		Arrays.fill(letters, '*');
		for(Map.Entry<Character, Integer> entry : getLettersOnWrongPlaces().entrySet()){
			letters[entry.getValue()] = entry.getKey();
		}
		for (Map.Entry<Character, Integer> entry : getLettersOnRigthPlaces().entrySet()){
			letters[entry.getValue()] = Character.toUpperCase(entry.getKey());
		}
		return new String(letters);
	}
	
	public String getLettersThatWordNotContains(){
		HashMap<Character, Integer> letters = getLettersWithState(LetterState.NOT_USED);
		String notUsedLetters = "";
		for (Character letter : letters.keySet()){
			notUsedLetters += letter + " ";
		}
		return notUsedLetters;
	}
	
	public void decreaseRemainingAttemptsCount(){
		game.decreaseRemainingAttemptsCount();
	}
	
	public int getRemainingAttemptsCount(){
		return game.getRemainingAttemptsCount();
	}
	
	public void stateLetters(String guessWord){
		game.stateLetters(guessWord);
	}
	
	public String getGuessWord(){
		return game.getGuessWord();
	}
}