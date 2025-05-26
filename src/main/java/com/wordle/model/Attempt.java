package logic.model;

public class Attempt{
	
	private final String guess;
	
	public Attempt(String guess){
		this.guess = guess;
	}
	
	public String getGuess(){
		return this.guess;
	}
	
}