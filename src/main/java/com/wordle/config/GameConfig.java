package com.wordle.config;

public class GameConfig {

    private int wordsLength;
    private int attemptsCount;

    public GameConfig() {
        wordsLength = 5;
        attemptsCount = 6;
    }

    public void setWordsLength(int newLength) {
        wordsLength = newLength;
    }

    public int getWordsLength() {
        return wordsLength;
    }

    public void setAttemptsCount(int newCount) {
        attemptsCount = newCount;
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

}
