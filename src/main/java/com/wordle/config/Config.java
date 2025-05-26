package com.wordle.config;

import com.wordle.repository.DictionaryRepository;
import com.wordle.repository.DictionaryRepositoryImplJSON;

public class Config {

    private int allowedAttemptsCount;
    private int wordsLength;
    private DictionaryRepository dictionaryRepository;

    public Config() {
        this.allowedAttemptsCount = 6;
        this.wordsLength = 5;
        this.dictionaryRepository = new DictionaryRepositoryImplJSON();
    }

    public void setAllowedAttemptsCount(int value) {
        if (value >= 1) {
            this.allowedAttemptsCount = value;
        }
        else throw new IllegalArgumentException("Attempts count must be a positive integer greater or equals 1");
    }

    public int getAllowedAttemptsCount() {
        return this.allowedAttemptsCount;
    }

    public void setWordsLength(int value) {
        if (value >= 4 && value <= 12) {
            this.wordsLength = value;
        }
        else throw new IllegalArgumentException("Game allows words length between 4 and 12");
    }

    public int getWordsLength() {
        return this.wordsLength;
    }

    public void setDictionaryRepository(DictionaryRepository repository) {
        this.dictionaryRepository = repository;
    }

    public DictionaryRepository getDictionaryRepository() {
        return this.dictionaryRepository;
    }

}
