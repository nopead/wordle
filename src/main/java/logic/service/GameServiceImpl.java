package main.logic.service;

import main.java.repository.IDictionaryRepository;
import main.java.repository.DictionaryRepositoryImplJson;
import main.java.logic.service.IGameService;
import main.java.logic.game.Game;
import main.java.logic.game.Attempt;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

public class GameServiceImpl implements IGameService{
	
	private final int HIDDEN_WORD_LENGTH = 5;
	private Game game;
	private HashSet<Character> rightPlacedLetters;
	private HashSet<Character> wrongPlacedLetters;
	private HashSet<Character> notUsedLetters;
	
	public GameServiceImpl(){
		initGame();
		rightPlacedLetters = new HashSet<Character>();
		wrongPlacedLetters = new HashSet<Character>();
		notUsedLetters = new HashSet<Character>() ;
	}
	
	private void initGame(){
		IDictionaryRepository dictionaryRepository = new DictionaryRepositoryImplJson();
		game = new Game(dictionaryRepository.getRandomWord(HIDDEN_WORD_LENGTH));
	}
	
	public boolean isAttemptsOver(){
		return game.attempts.size() >= game.getAttemptsCount();
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return guessWord.equals(game.getHiddenWord());
	}
	
	public boolean isUserInputIsWord(String input){
		IDictionaryRepository dictionaryRepository = new DictionaryRepositoryImplJson();
		return dictionaryRepository.isDictionaryContainsWord(HIDDEN_WORD_LENGTH, input);
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
		Attempt currentAttempt = game.attempts.peekLast();
		return getGuessingResult(currentAttempt.getGuess());
	}
	
	public void stateLetters(){
		String guessWord = game.attempts.peekLast().getGuess();
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
		return game.getAttemptsCount() - game.attempts.size();
	}
	
	public String getHiddenWord(){
		return game.getHiddenWord();
	}
	
	public void recordAttempt(String guess){
		game.attempts.addLast(new Attempt(guess));
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