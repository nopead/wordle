package main.test;

import main.java.logic.classes.*;
import main.java.repository.classes.WordsFileReader;

import java.util.ArrayList;


class Main{
	public static void main(String[] args){
		String[] words = WordsFileReader.getAllWords();
		System.out.println(words.length);
		
		GameSession gs = new GameSession();
		System.out.println("Осталось попыток: " + gs.getAttemptsRemaining());
		System.out.println("Игра окончена? - " + gs.attemptsAnalyzer.isGameOver());
		
		String word = "alarm";
		if (WordInDictionaryChecker.isExists(words, word)){
			System.out.println("word: \"" + word + "\" exists in words");
		}
		else{
			System.out.println("word: \"" + word + "\" does not exists in words");
		}	
		
		System.out.println("Тест уменьшения количества попыток");
		gs.remainingAttemptsDecreaser.decrease();
		System.out.println("Осталось попыток: " + gs.getAttemptsRemaining());
		gs.remainingAttemptsDecreaser.decrease();
		System.out.println("Осталось попыток: " + gs.getAttemptsRemaining());
		gs.remainingAttemptsDecreaser.decrease();
		System.out.println("Осталось попыток: " + gs.getAttemptsRemaining());
		gs.remainingAttemptsDecreaser.decrease();
		System.out.println("Осталось попыток: " + gs.getAttemptsRemaining());
		
		word = "about";
		if(InputValidator.isWord(words, word)){
			gs.guessHandler.compareLetters(gs.getHiddenWord(), word);
		}
		else{
			System.out.println(word + " is not a word!");
		}
		
		ArrayList<LetterStateWrapper> letterStates = gs.getLetterStates();
		for (LetterStateWrapper state : letterStates){
			System.out.println(state.toString());
		}
		
		System.out.println("Слово отгадано? - " + gs.guessedLettersAnalyzer.isGuessed());
		
		
	}
}