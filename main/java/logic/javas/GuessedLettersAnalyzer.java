package main.java.logic.classes;

import main.java.logic.classes.LetterStateWrapper;

public class GuessedLettersAnalyzer{
	GameSession gameSession;
	
	public GuessedLettersAnalyzer(GameSession gameSession){
		this.gameSession = gameSession;
	}
	
	public boolean isGuessed() {
		int charsGuessedCount = 0;
		for (LetterStateWrapper stateRecord: gameSession.lettersStates){
			if (stateRecord.getState().equals(LetterState.RIGHT_PLACE)){
				charsGuessedCount++;
			}
		}
		return (charsGuessedCount == gameSession.HIDDEN_WORD.chars().count());
	}
}