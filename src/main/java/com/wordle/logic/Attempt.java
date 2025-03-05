package com.wordle.logic;

public class Attempt{
	
	private	String guess;
	
	public Attempt(String guess){
		this.guess = guess;
	}
	
	public String getGuess(){
		return this.guess;
	}
	
}