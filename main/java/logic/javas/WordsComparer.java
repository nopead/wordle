package main.java.logic.classes;

import main.java.logic.classes.GameLettersStatesUpdater;

public class WordsComparer{
	
	private GameLettersStatesUpdater letterStatesUpdater;
	
	public WordsComparer(GameLettersStatesUpdater letterStatesUpdater){
		this.letterStatesUpdater = letterStatesUpdater;
	}
	
	public void compare(String hiddenWord, String userWord){
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
