package main.test;

import main.java.logic.classes.GameSession;
import main.java.logic.classes.LetterState;
import main.java.logic.classes.RandomWordGetter;
import main.java.logic.classes.RemainingAttemptsDecreaser;
import main.java.logic.classes.UserWordOnExistChecker;
import main.java.logic.classes.NoMoreAttemptsChecker;
import main.java.logic.classes.GameLettersStatesUpdater;
import main.java.logic.classes.UserGuessedWordChecker;

import main.java.repository.classes.WordsFileReader;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;


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
		statesUpdater.update('a', LetterState.RIGHT_PLACE);
		statesUpdater.update('b', LetterState.RIGHT_PLACE);
		statesUpdater.update('o', LetterState.RIGHT_PLACE);
		statesUpdater.update('u', LetterState.RIGHT_PLACE);
		statesUpdater.update('d', LetterState.WRONG_PLACE);
		
		UserGuessedWordChecker ugw = new UserGuessedWordChecker(gs);
		System.out.println("Is word guessed: " + ugw.isGuessed());
		
	}
}