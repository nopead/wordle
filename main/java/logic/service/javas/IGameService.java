package main.java.logic.service.classes;

interface IGameService{
	
	public void startGame();
	
	public ArrayList<LetterStateWrapper> getLettersStates();
	
	public boolean isWordGuessed();
	
	public boolean isAttemptsOver(); 
	
	public boolean isGuessWordIsAnswer();
	
}