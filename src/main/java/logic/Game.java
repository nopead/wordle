package main.java.logic;

import main.java.logic.Attempt;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

public class Game{
	
	private final int attemptsCount = 6;
	private final String hiddenWord;
	
	private Set<Character> rightPlacedLetters;
	private Set<Character> wrongPlacedLetters;
	private Set<Character> notUsedLetters;
	
	public List<Attempt> attempts;
	
	public Game(String wordToGuess){
		init();
		this.hiddenWord = wordToGuess;
	}
	
	private void init(){
		attempts = new LinkedList<>();
		rightPlacedLetters = new HashSet<>();
		wrongPlacedLetters = new HashSet<>();
		notUsedLetters = new HashSet<>();
	}
	
	// public Game(String wordToGuess, int attemptsCount){	
		// this();
		// this.hiddenWord = wordToGuess;
		// this.attemptsCount = attemptsCount;
	// }
	
	public String getHiddenWord(){
		return this.hiddenWord;
	}
	
	public String getRightPlacedLetters(){
		return this.rightPlacedLetters.toString();
	}
	
	public String getWrongPlacedLetters(){
		return this.wrongPlacedLetters.toString();
	}
	
	public String getNotUsedLetters(){
		return this.notUsedLetters.toString();
	}
	
	public boolean isAttemptsOver(){
		return this.attempts.size() >= attemptsCount;
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return guessWord.equals(this.hiddenWord);
	}
	
	public void stateLetters(){
		String guessWord = attempts.getLast().getGuess();
		for(int i = 0; i < guessWord.length(); i++){
			if (Character.compare(guessWord.charAt(i), hiddenWord.charAt(i)) == 0){
				rightPlacedLetters.add(guessWord.charAt(i));
			}
			else if (hiddenWord.indexOf(guessWord.charAt(i)) > -1){
				wrongPlacedLetters.add(guessWord.charAt(i));
			}
			else{
				notUsedLetters.add(guessWord.charAt(i));
			}
		}
		this.wrongPlacedLetters.removeAll(rightPlacedLetters);
	}
	
	public String showAttemptEncryptResult(){
		String currentGuess = attempts.getLast().getGuess();
		char[] letters = new char[currentGuess.length()];
		Arrays.fill(letters, '*');
		for (int i = 0; i < currentGuess.length(); i++){
			if (Character.compare(currentGuess.charAt(i), hiddenWord.charAt(i)) == 0){
				letters[i] = Character.toUpperCase(currentGuess.charAt(i));
			}
			else if (hiddenWord.indexOf(currentGuess.charAt(i)) > -1){
				letters[i] = currentGuess.charAt(i);
			}
		}
		return String.valueOf(letters);
	}
	
	public int getRemainingAttemptsCount(){
		return attemptsCount - attempts.size();
	}
	
	public void recordAttempt(String guess){
		this.attempts.addLast(new Attempt(guess));
	}
	
}