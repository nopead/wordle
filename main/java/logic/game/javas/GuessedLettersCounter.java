package main.java.logic.game.classes;

import main.java.logic.game.classes.LetterStateWrapper;

public class GuessedLettersCounter{
	GameSession gameSession;
	
	public GuessedLettersCounter(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isWordGuessed() {
		int charsGuessedCount = 0;
		for (LetterStateWrapper stateRecord: gameSession.lettersStates){
			if (stateRecord.getState().equals(LetterState.RIGHT_PLACE)){
				charsGuessedCount++;
			}
		}
		return (charsGuessedCount == gameSession.WORD_TO_GUESS.chars().count());
	}
}