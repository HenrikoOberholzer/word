package com.language.word.service;

import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Created by Henriko on 2022/09/28 
*/
@Service
public class AnagramService {

    public boolean areAnagram(String currentWord, String possibleAnagram) {
        //Sanity check for null and so on.
        if(Strings.isNullOrEmpty(currentWord)) {
            return false;
        }
        if(Strings.isNullOrEmpty(possibleAnagram)) {
            return false;
        }
        //

        //If lenght does not match there are no way this is a anagram.
        if(currentWord.length() != possibleAnagram.length()) {
            return false;
        }

        char[] lettersOfWord = currentWord.toCharArray();
        char[] lettersOfPossibleAnagram = possibleAnagram.toCharArray();

        Arrays.sort(lettersOfWord);
        Arrays.sort(lettersOfPossibleAnagram);

        //Checking in all the letters match.
        return Arrays.equals(lettersOfWord, lettersOfPossibleAnagram);

        // TODO: Check if it is a word?

        //
    }
}
