package main.java.logic.classes;

import main.java.logic.classes.GuessLettersStateManager;

public class GuessHandler{
	
	private GuessLettersStateManager letterStatesUpdater;
	
	public GuessHandler(GuessLettersStateManager letterStatesUpdater){
		this.letterStatesUpdater = letterStatesUpdater;
	}
	
	public void compareLetters(String hiddenWord, String userWord){
		for (int i = 0; i < hiddenWord.length(); i++){
			if (hiddenWord.indexOf(userWord.charAt(i)) == -1){
				letterStatesUpdater.addNotExisting(userWord.charAt(i));
			}
			else if ((Character.compare(hiddenWord.charAt(i), userWord.charAt(i))) == 0){
				letterStatesUpdater.addRight(hiddenWord.charAt(i), i);
			}
			else {
				letterStatesUpdater.addExistingOnOtherPlace(hiddenWord.charAt(i), i);
			}
		}
	}
}
