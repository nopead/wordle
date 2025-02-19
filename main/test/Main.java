package main.test;

import java.util.ArrayList;
import main.java.logic.service.classes.IGameService;
import main.java.logic.service.classes.GameServiceImpl;

class Main{
	public static void main(String[] args){
		IGameService gameService = new GameServiceImpl();
		
		gameService.startGame();
		
		System.out.println(gameService.isAttemptsOver());
	}
}