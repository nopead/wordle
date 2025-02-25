package main.logic.service;

import main.logic.service.IGameService;
import main.logic.game.Game;
import main.logic.game.Attempt;
import main.logic.game.WordInDictionaryChecker;
import main.logic.game.DictionaryGetter;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

public class GameServiceImpl implements IGameService{
	
	private Game game;
	private HashSet<Character> rightPlacedLetters;
	private HashSet<Character> wrongPlacedLetters;
	private HashSet<Character> notUsedLetters;
	
	public GameServiceImpl(){
		game = new Game("about");
		rightPlacedLetters = new HashSet<Character>();
		wrongPlacedLetters = new HashSet<Character>();
		notUsedLetters = new HashSet<Character>() ;
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
	
	private String getGuessingResult(String guessWord){
		char[] letters = new char[guessWord.length()];
		Arrays.fill(letters, '*');
		for (int i = 0; i < guessWord.length(); i++){
			if (Character.compare(guessWord.charAt(i), game.getHiddenWord().charAt(i)) == 0){
				letters[i] = Character.toUpperCase(guessWord.charAt(i));
			}
			else if (game.getHiddenWord().indexOf(guessWord.charAt(i)) > -1){
				letters[i] = guessWord.charAt(i);
			}
		}
		return String.valueOf(letters);
	}
	
	public String getAttemptGuessResult(){
		Attempt currentAttempt = game.getAttempts().peekLast();
		return getGuessingResult(currentAttempt.getGuess());
	}
	
	public void stateLetters(){
		String guessWord = game.getAttempts().peekLast().getGuess();
		for(int i = 0; i < guessWord.length(); i++){
			if (Character.compare(guessWord.charAt(i), game.getHiddenWord().charAt(i)) == 0){
				rightPlacedLetters.add(guessWord.charAt(i));
			}
			else if (game.getHiddenWord().indexOf(guessWord.charAt(i)) > -1){
				wrongPlacedLetters.add(guessWord.charAt(i));
			}
			else{
				notUsedLetters.add(guessWord.charAt(i));
			}
		}
		removeRightWrongCoincidence();
	}
	
	private void removeRightWrongCoincidence(){
		this.wrongPlacedLetters.removeAll(rightPlacedLetters);
	}
	
	public int getRemainingAttemptsCount(){
		return game.getAttemptsCount() - game.getUsedAttemptsCount();
	}
	
	public String getHiddenWord(){
		return game.getHiddenWord();
	}
	
	public void recordAttempt(String guess){
		game.recordAttempt(new Attempt(guess));
	}
	
	public String getAllRightPlacedLetters(){
		return this.rightPlacedLetters.toString();
	}
	
	public String getAllWrongPlacedLetters(){
		return this.wrongPlacedLetters.toString();
	}
	
	public String getAllNotUsedLetters(){
		return this.notUsedLetters.toString();
	}
	
}