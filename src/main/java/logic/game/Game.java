package main.java.logic.game;

import main.java.logic.game.Attempt;
import java.util.LinkedList;

public class Game{
	private static final int ATTEMPTS_COUNT = 6;
	private final String hiddenWord;
	public LinkedList<Attempt> attempts;
	
	public Game(String wordToGuess){	
		attempts = new LinkedList<Attempt>();
		hiddenWord = wordToGuess;
	}
	
	public int getAttemptsCount(){
		return this.ATTEMPTS_COUNT;
	}
	
	public String getHiddenWord(){
		return this.hiddenWord;
	}
}