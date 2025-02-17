package main.java.logic.classes;

import main.java.logic.classes.LetterState;
import main.java.logic.classes.GameSession; 
 
public class GameLettersStatesUpdater{
	GameSession gameSession;
	
	public GameLettersStatesUpdater(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public void update(Character letter, LetterState state){
		if (!this.gameSession.lettersStates.containsKey(letter)){
			this.gameSession.lettersStates.put(letter, state);
		}
	}
}