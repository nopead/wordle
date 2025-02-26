package main.logic.game;

import main.logic.game.Attempt;
import java.util.LinkedList;

public class Game{
	protected final int attemptsCount = 6;
	private final String HIDDEN_WORD;
	private LinkedList<Attempt> attempts;
	
	public Game(String wordToGuess){	
		attempts = new LinkedList<Attempt>();
		HIDDEN_WORD = wordToGuess;
	}
	
	public int getAttemptsCount(){
		return this.attemptsCount;
	}
	
	public int getUsedAttemptsCount(){
		return this.attempts.size();
	}
	
	public void recordAttempt(Attempt attempt){
		attempts.addLast(attempt);
	}
	
	public LinkedList<Attempt> getAttempts(){
		return this.attempts;
	}
	
	public String getHiddenWord(){
		return this.HIDDEN_WORD;
	}
}