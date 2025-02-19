package main.java.logic.game.classes;

import main.java.logic.game.classes.LettersStateManager;

public class GuessWordLettersAnalyzer{
	
	private LettersStateManager letterStatesManager;
	
	public GuessWordLettersAnalyzer(LettersStateManager letterStatesManager){
		this.letterStatesManager = letterStatesManager;
	}
		
	public void compareLetters(String hiddenWord, String userWord){
		for (int i = 0; i < hiddenWord.length(); i++){
			char currentLetter = userWord.charAt(i);
			if(!letterStatesManager.isLetterStated(currentLetter)){
				if (hiddenWord.indexOf(currentLetter) == -1){
					letterStatesManager.addNotExisting(userWord.charAt(i));
				}
				else if ((Character.compare(hiddenWord.charAt(i), currentLetter)) == 0){
					letterStatesManager.addRight(hiddenWord.charAt(i), i);
				}
				else {
					letterStatesManager.addExistingOnOtherPlace(currentLetter, i);
				}
			}
		}
	}
}
