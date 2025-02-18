package main.java.logic.classes;

import main.java.logic.classes.LetterState;
import main.java.logic.classes.GameSession; 
import main.java.logic.classes.LetterStateWrapper;
 
public class GameLettersStatesUpdater{
	GameSession gameSession;
	
	public GameLettersStatesUpdater(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public void addRight(char letter, int index){
		this.gameSession.lettersStates.add(new LetterStateWrapper(letter, index, LetterState.RIGHT_PLACE));
	}
	
	public void addExistingOnOtherPlace(char letter, int index){
		this.gameSession.lettersStates.add(new LetterStateWrapper(letter, index, LetterState.WRONG_PLACE));
	}
	
	public void addNotExisting(char letter){
		this.gameSession.lettersStates.add(new LetterStateWrapper(letter));
	}
}