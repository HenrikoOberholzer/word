package com.language.word.dto;

import java.io.Serializable;

/*
 Created by Henriko on 2022/10/16 
*/
public class AnagramRequest implements Serializable {
    private String currentWord;
    private String possibleAnagram;

    public AnagramRequest() {
    }

    public AnagramRequest(String currentWord, String possibleAnagram) {
        this.currentWord = currentWord;
        this.possibleAnagram = possibleAnagram;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public String getPossibleAnagram() {
        return possibleAnagram;
    }

    public void setPossibleAnagram(String possibleAnagram) {
        this.possibleAnagram = possibleAnagram;
    }
}
