package com.language.word.service;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 Created by Henriko on 2022/09/28 
*/
@Service
public class AnagramService {

    public boolean areAnagram(String currentWord, String possibleAnagram) {
        //Basic sanity checks
        if (sanityCheck(currentWord, possibleAnagram)) {
            return false;
        }

        //Remove extra spaces
        currentWord = currentWord.replaceAll(" ", "");
        possibleAnagram = possibleAnagram.replaceAll(" ", "");

        //If length does not match there are no way this is a anagram.
        if(currentWord.length() != possibleAnagram.length()) {
            return false;
        }

        //Test for numbers
        Pattern numberPattern = Pattern.compile("[0-9]");
        char[] currentWordArray = currentWord.toCharArray();
        if (charMatchPattern(numberPattern, currentWordArray)) {
            return false;
        }

        char[] possibleAnagramArray = possibleAnagram.toCharArray();

        if (charMatchPattern(numberPattern, possibleAnagramArray)) {
            return false;
        }

        //Test for symbols
        Pattern symbolPattern = Pattern.compile("[-+.^:,!@#%$^&*()_={};<>?/]");
        if (charMatchPattern(symbolPattern, currentWordArray)) {
            return false;
        }

        if (charMatchPattern(symbolPattern, possibleAnagramArray)) {
            return false;
        }
        //

        currentWord = currentWord.toLowerCase();
        possibleAnagram = possibleAnagram.toLowerCase();

        char[] lettersOfWord = currentWord.toCharArray();
        char[] lettersOfPossibleAnagram = possibleAnagram.toCharArray();

        Arrays.sort(lettersOfWord);
        Arrays.sort(lettersOfPossibleAnagram);

        //Checking in all the letters match.
        return Arrays.equals(lettersOfWord, lettersOfPossibleAnagram);
    }

    private boolean sanityCheck(String currentWord, String possibleAnagram) {
        //Sanity check for null and so on.
        if(currentWord == null || currentWord.isBlank()) {
            return true;
        }
        if(possibleAnagram == null || possibleAnagram.isBlank()) {
            return true;
        }
        //
        return false;
    }

    //Using regex patterns to determine if we find a match for thing. Starting with numbers and symbols but quite generic.
    private boolean charMatchPattern(Pattern pattern, char[] currentWordArray) {
        for(char currentChar:currentWordArray) {
            Matcher currentCharNumbersMatcher = pattern.matcher(currentChar + "");
            if(currentCharNumbersMatcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
