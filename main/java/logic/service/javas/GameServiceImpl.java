package main.java.logic.service.classes;

import main.java.logic.service.classes.IGameService;
import main.java.logic.game.classes.Game;
import main.java.logic.game.classes.WordInDictionaryChecker;
import main.java.logic.game.classes.DictionaryGetter;

public class GameServiceImpl implements IGameService{
	
	private Game game;
	
	public void startGame(){
		game = new Game();
	}
	
	public boolean isAttemptsOver(){
		return game.isAttemptsOver();
	}
	
	public boolean isGuessWordIsAnswer(String guessWord){
		return game.compareWithSecret(guessWord);
	}
	
	public boolean isUserInputIsWord(String input){
		String[] dictionary = DictionaryGetter.getDictionary();
		return WordInDictionaryChecker.isExists(dictionary, input);
	}
	
	public String getLettersStates(){
		return "";
	}
	
	public void decreaseRemainingAttemptsCount(){
		game.decreaseRemainingAttemptsCount();
	}
	
	public int getRemainingAttemptsCount(){
		return game.getRemainingAttemptsCount();
	}
	
	public void stateLetters(String guessWord){
		game.stateLetters(guessWord);
	}
}