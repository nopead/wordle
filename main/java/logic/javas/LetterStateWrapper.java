package main.java.logic.classes;

import main.java.logic.classes.LetterState;

class LetterStateWrapper{
	private Character character;
	private int index;
	private LetterState state;
	
	LetterStateWrapper(Character character){
		this.character = character;
		this.index = -1;
		this.state = LetterState.WRONG_PLACE;
	}
	
	LetterStateWrapper(Character character, int index, LetterState state){
		this.character = character;
		this.index = index;
		this.state = state;
	}
	
	public LetterState getState(){
		return this.state;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public Character getLetter(){
		return this.character;
	}
	
	public String toString(){
		String result = "Символ " + this.character;
		if (this.state == LetterState.NOT_USED){
			result += " не используется в загаданном слове";
		}
		else if (this.state == LetterState.WRONG_PLACE){
			result += " есть в загаданном слове, но на другом месте";
		}
		else {
			result += " угадан на позиции " + this.index;
		}
		return result;
	}
}