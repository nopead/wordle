package com.wordle.logic;

import com.wordle.logic.Attempt;
import java.util.stream.Stream;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game{
	
	private final int allowedAttemptsCount;
	private final String hiddenWord;
	
	private Set<Character> rightPlacedLetters = new HashSet<>();
	private Set<Character> wrongPlacedLetters = new HashSet<>();
	private Set<Character> notUsedLetters = new HashSet<>();
	private List<Attempt> attempts = new ArrayList<>();
	
	public Game(String wordToGuess){
		allowedAttemptsCount = 6;
		this.hiddenWord = wordToGuess;
	}
	
	public Game(String wordToGuess, int allowedAttemptsCount){	
		this.hiddenWord = wordToGuess;
		this.allowedAttemptsCount = allowedAttemptsCount;
	}
	
	public String getHiddenWord(){
		return hiddenWord;
	}
	
	public String getRightPlacedLetters(){
		return rightPlacedLetters.toString();
	}
	
	public String getWrongPlacedLetters(){
		return wrongPlacedLetters.toString();
	}
	
	public String getNotUsedLetters(){
		return notUsedLetters.toString();
	}
	
	public boolean isAttemptsOver(){
		return attempts.size() >= allowedAttemptsCount;
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
		wrongPlacedLetters.removeAll(rightPlacedLetters);
	}
	
	//вынести два метода из класса игры
	 
	private void hideLettersByGuessedCount(List<Character> letters, Character letter){
		long currentLetterInWordCount = hiddenWord.chars().filter(ch -> ch == letter).count();
		long currentLetterInListCount = letters.stream().filter(ch -> Character.toLowerCase(ch) == letter).count();
		while(currentLetterInListCount > currentLetterInWordCount){
			letters.set(letters.lastIndexOf(letter), '*');
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
				hideLettersByGuessedCount(letters, currentLetter);
			}
			else if (hiddenWord.indexOf(currentLetter) > -1){
				letters.add(currentLetter);
				hideLettersByGuessedCount(letters, currentLetter);
			}
			else {
				letters.add('*');
			}
		}
		return String.valueOf(letters).replaceAll("\\[|\\]|, ", ""); //преобразование массива - [el, el, el] -> el el el
	}
	
	// ============================
	
	public int getRemainingAttemptsCount(){
		return allowedAttemptsCount - attempts.size();
	}
	
	public void recordAttempt(String guess){
		attempts.add(new Attempt(guess));
	}
	
}