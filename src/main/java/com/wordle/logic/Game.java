package com.wordle.logic;

import com.wordle.logic.Attempt;
import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game{
	
	private final int attemptsCount;
	private final String hiddenWord;
	
	private Set<Character> rightPlacedLetters = new HashSet<>();
	private Set<Character> wrongPlacedLetters = new HashSet<>();
	private Set<Character> notUsedLetters = new HashSet<>();
	private List<Attempt> attempts = new ArrayList<>();
	
	public Game(String wordToGuess){
		this.attemptsCount = 6;
		this.hiddenWord = wordToGuess;
	}
	
	public Game(String wordToGuess, int attemptsCount){	
		this.hiddenWord = wordToGuess;
		this.attemptsCount = attemptsCount;
	}
	
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
	
	private void hideLettersByCount(List<Character> letters, Character letter){
		long currentLetterInWordCount = hiddenWord.chars().filter(ch -> ch == letter).count();
		long currentLetterInListCount = letters.stream().filter(ch -> Character.toLowerCase(ch) == letter).count();
		while(currentLetterInListCount > currentLetterInWordCount){
			int lastLetterIndex = letters.lastIndexOf(letter);
			letters.remove(lastLetterIndex);
			letters.add(lastLetterIndex, '*');
			currentLetterInListCount--;
		}
	}
	
	public String showAttemptEncryptResult(){
		String currentGuess = attempts.getLast().getGuess();
		List<Character> letters = new ArrayList<>();
		for (int i = 0; i < currentGuess.length(); i++){
			Character currentLetter = currentGuess.charAt(i);
			if (Character.compare(currentLetter, hiddenWord.charAt(i)) == 0){
				letters.add(Character.toUpperCase(currentGuess.charAt(i)));
				hideLettersByCount(letters, currentLetter);
			}
			else if (hiddenWord.indexOf(currentLetter) > -1){
				letters.add(currentLetter);
				hideLettersByCount(letters, currentLetter);
			}
			else {
				letters.add('*');
			}
		}
		return String.valueOf(letters).replaceAll("\\[|\\]|, ", "");
	}
	
	public int getRemainingAttemptsCount(){
		return attemptsCount - attempts.size();
	}
	
	public void recordAttempt(String guess){
		this.attempts.add(new Attempt(guess));
	}
	
}