package main.test;

import main.java.logic.classes.GameSession;
import main.java.logic.classes.LetterState;
import main.java.logic.classes.RandomWordGetter;
import main.java.logic.classes.RemainingAttemptsDecreaser;
import main.java.logic.classes.UserWordOnExistChecker;
import main.java.logic.classes.NoMoreAttemptsChecker;
import main.java.logic.classes.GameLettersStatesUpdater;
import main.java.logic.classes.UserGuessedWordChecker;
import main.java.logic.classes.WordsComparer;
import main.java.logic.classes.LetterStateWrapper;
import main.java.logic.classes.InputValidator;

import main.java.repository.classes.WordsFileReader;

import java.util.ArrayList;
import java.util.Set;


class Main{
	public static void main(String[] args){
		Set<String> words = WordsFileReader.getAllWords();
		System.out.println(words.size());
		
		GameSession gs = new GameSession();
		System.out.println(gs.getAttemptsRemaining());
		RemainingAttemptsDecreaser decr = new RemainingAttemptsDecreaser(gs);
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		
		String word = "alarm";
		if (UserWordOnExistChecker.check(word)){
			System.out.println("word: \"" + word + "\" exists in words");
		}
		else{
			System.out.println("word: \"" + word + "\" does not exists in words");
		}	
		
		NoMoreAttemptsChecker goc = new NoMoreAttemptsChecker(gs);
		System.out.println(goc.isGameOver());
		
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		decr.decrease();
		System.out.println(gs.getAttemptsRemaining());
		System.out.println(goc.isGameOver());
		
		GameLettersStatesUpdater statesUpdater = new GameLettersStatesUpdater(gs);
		WordsComparer wc = new WordsComparer(statesUpdater);
		
		String input = "about";
		if(InputValidator.isWord(input)){
			wc.compare(gs.getHiddenWord(), input);
		}
		else{
			System.out.println(input + " is not a word!");
		}
		ArrayList<LetterStateWrapper> letterStates = gs.getLetterStates();
		
		for (LetterStateWrapper state : letterStates){
			System.out.println(state.toString());
		}
		
		UserGuessedWordChecker ugw = new UserGuessedWordChecker(gs);
		System.out.println("Is word guessed: " + ugw.isGuessed());
	}
}