package main.java.logic.classes;

import java.util.Map;
import java.util.Map.Entry;

public class UserGuessedWordChecker{
	GameSession gameSession;
	
	public UserGuessedWordChecker(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isGuessed() {
		int charsGuessedCount = 0;
		for (Map.Entry<Character, LetterState> entry : gameSession.lettersStates.entrySet()){
			if (entry.getValue().equals(LetterState.RIGHT_PLACE)){
				charsGuessedCount++;
			}
		}
		return (charsGuessedCount == gameSession.HIDDEN_WORD.chars().distinct().count());
	}
}