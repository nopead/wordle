package main.java.logic.game.classes;

import main.java.logic.game.classes.LetterState;
import main.java.logic.game.classes.GameSession; 
import main.java.logic.game.classes.LetterStateWrapper;
import java.util.ArrayList;

  
public class LettersStateManager{
	protected GameSession gameSession;
	
	public LettersStateManager(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	protected boolean isLetterStated(char letter){
		ArrayList<LetterStateWrapper> lettersStates = gameSession.getLettersStates();
		for (LetterStateWrapper letterState : lettersStates){
			if (Character.compare(letterState.getLetter(), letter) == 0){
				return true;
			}
		}
		return false;
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