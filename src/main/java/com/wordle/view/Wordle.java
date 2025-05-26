package com.wordle.view;

import java.util.ArrayList;
import java.util.List;
import com.wordle.io.Printable;
import com.wordle.io.ConsolePrinter;
import com.wordle.io.Readable;
import com.wordle.io.ConsoleReader;
import com.wordle.model.RecordAttemptResponse;
import com.wordle.view.constants.MenuMessage;
import com.wordle.view.constants.MenuErrorMessage;
import com.wordle.config.Config;
import com.wordle.logic.Game;

public class Wordle {

	private final Readable reader;
	private final Printable printer;
	private final Config config;

	private Game game;

	public Wordle() {
		reader = new ConsoleReader();
		printer = new ConsolePrinter();
		config = new Config();
	}

	public void run() {
		printer.printMessage(MenuMessage.GREETING_TEXT);
		loadMainMenu();
	}
	
	void loadMainMenu() {
		printer.printMessage(MenuMessage.MAIN_MENU_TEXT);
		handleMainMenuUserResponse();
	}
	
	private void handleMainMenuUserResponse() {
		int responce = 0;
		do {
			try{ 
				responce = reader.readDigit();
				switch (responce) {
					case 1: {
						startGame();
						break;
					}
					case 2: {
						printer.printMessage(MenuMessage.GAME_RULES_TEXT);
						loadMainMenu();
						break;
					}
					case 3: {
						System.exit(0);
						break;
					}
					default: {
						printer.printMessage(MenuErrorMessage.VALUE_OUT_OF_BOUNDS_EXCEPTION);
						break;
					}
				}
			} catch (NumberFormatException e){
				printer.printMessage(MenuErrorMessage.ONLY_DIGITS_REQUIRED);
			}
		}
		while (responce < 1 || responce > 3);
	}

	private void startGame() {
		game = new Game(config);
		readAttempts();
	}

	private void readAttempts() {
		while (!game.isGameOver()) {
			printer.printMessage(MenuMessage.INPUT_TEXT_REQUEST);
			String guess = reader.readWord().toLowerCase();
			RecordAttemptResponse attemptRecordResult = game.recordAttempt(guess);
			if (attemptRecordResult.isSuccess()) {
				String attemptResult = game.getLastAttemptResult();
				printDetailedResult(attemptResult);
			}
			else {
				printer.printMessage(attemptRecordResult.getMessage());
			}
			printer.printMessage("Attempts remaining: " + game.getRemainingAttemptsCount());
		}
		handleGameOver();
	}

	private void printDetailedResult(String attemptResult){
		printer.printMessage("==========RESULT==========");
		printer.printMessage(attemptResult);
		printer.printMessage("==========================");
	}

	private void handleGameOver() {
		if (game.isGuessed()) {
			printer.printMessage(MenuMessage.CONGRATULATION_TEXT);
		}else {
			printer.printMessage(MenuMessage.COMPASSION_TEXT);
			printer.printMessage("Secret word was: " + game.getHiddenWord());
		}
		reload();
	}

	private void reload() {
		this.game = null;
		loadMainMenu();
	}
	
}
