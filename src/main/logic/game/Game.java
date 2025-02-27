package main.logic.game;

import main.logic.game.Attempt;
import java.util.LinkedList;

public class Game{
	private final int attemptsCount = 6;
	private final String HIDDEN_WORD;
	public LinkedList<Attempt> attempts;
	
	public Game(String wordToGuess){	
		attempts = new LinkedList<Attempt>();
		HIDDEN_WORD = wordToGuess;
	}
	
	public int getAttemptsCount(){
		return this.attemptsCount;
	}
	
	public String getHiddenWord(){
		return this.HIDDEN_WORD;
	}
}