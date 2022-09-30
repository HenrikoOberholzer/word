package com.language.word.service;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 Created by Henriko on 2022/09/28 
*/
@Service
public class AnagramService {

    public boolean areAnagram(String currentWord, String possibleAnagram) {
        if (sanityCheck(currentWord, possibleAnagram)) {
            return false;
        }

        //Remove extra spaces
        currentWord = currentWord.replaceAll(" ", "");
        possibleAnagram = possibleAnagram.replaceAll(" ", "");

        if (notAnagram(currentWord, possibleAnagram)) {
            return false;
        }

        currentWord = currentWord.toLowerCase();
        possibleAnagram = possibleAnagram.toLowerCase();

        char[] lettersOfWord = currentWord.toCharArray();
        char[] lettersOfPossibleAnagram = possibleAnagram.toCharArray();

        Arrays.sort(lettersOfWord);
        Arrays.sort(lettersOfPossibleAnagram);

        //Checking in all the letters match.
        return Arrays.equals(lettersOfWord, lettersOfPossibleAnagram);
    }

    private boolean notAnagram(String currentWord, String possibleAnagram) {
        //If length does not match there are no way this is a anagram.
        if(currentWord.length() != possibleAnagram.length()) {
            return true;
        }

        //Test for numbers
        String numbers = "0123456789";
        char[] numbersArray = numbers.toCharArray();
        List<String> lettersWordArray = new ArrayList<>();

        extractLettersToList(currentWord, lettersWordArray);

        if (checkValueInArray(lettersWordArray, numbersArray)) {
            return true;
        }

        char[] possibleAnagramArray = possibleAnagram.toCharArray();

        List<String> lettersPossibleAnagramArray = new ArrayList<>();
        extractLettersToList(possibleAnagram, lettersPossibleAnagramArray);

        if (checkValueInArray(lettersPossibleAnagramArray, numbersArray)) {
            return true;
        }

        //Test for symbols
        Pattern symbolPattern = Pattern.compile("[-+.^:,!@#%$^&*()_={};<>?/]");
        char[] currentWordArray = currentWord.toCharArray();

        if (charMatchPattern(symbolPattern, currentWordArray)) {
            return true;
        }

        if (charMatchPattern(symbolPattern, possibleAnagramArray)) {
            return true;
        }
        //
        return false;
    }

    private boolean sanityCheck(String currentWord, String possibleAnagram) {
        //Sanity check for null and so on.
        if(Strings.isNullOrEmpty(currentWord)) {
            return true;
        }
        if(Strings.isNullOrEmpty(possibleAnagram)) {
            return true;
        }
        //
        return false;
    }

    private void extractLettersToList(String currentWord, List<String> lettersWordArray) {
        for(char currentLetter:currentWord.toCharArray()) {
            lettersWordArray.add(currentLetter + "");
        }
    }

    private boolean checkValueInArray(List<String> currentWord, char[] numbersArray) {
        for(char currentNumber:numbersArray) {
            if(currentWord.contains(currentNumber + "")) {
                return true;
            }
        }
        return false;
    }

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
