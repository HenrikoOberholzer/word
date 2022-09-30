package com.language.word.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnagramServiceTest {

    @Autowired
    private AnagramService anagramService;

    @Test
    void areAnagramNullBothInputsShouldBeFalse() {
        boolean response = anagramService.areAnagram(null, null);
        assertFalse(response);
    }

    @Test
    void areAnagramNullCurrentValueShouldBeFalse() {
        boolean response = anagramService.areAnagram(null, "value");
        assertFalse(response);
    }

    @Test
    void areAnagramNullPossibleAnagramShouldBeFalse() {
        boolean response = anagramService.areAnagram("newValue", null);
        assertFalse(response);
    }

    @Test
    void areAnagramLengthMismatchShouldBeFalse() {
        boolean response = anagramService.areAnagram("newValue", "value");
        assertFalse(response);
    }

    @Test
    void areAnagramBothNumbersFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("2no", "2on");
        assertFalse(response);
    }

    @Test
    void areAnagramFirstNumberFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("2no", "on");
        assertFalse(response);
    }

    @Test
    void areAnagramSecondNumberFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("no", "o2n");
        assertFalse(response);
    }

    //
    @Test
    void areAnagramBothSymbolsFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("$no", "$on");
        assertFalse(response);
    }

    @Test
    void areAnagramFirstSymbolFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("*no", "on");
        assertFalse(response);
    }

    @Test
    void areAnagramSecondSymbolFoundShouldBeFalse() {
        boolean response = anagramService.areAnagram("no", "on)");
        assertFalse(response);
    }



    //
    @Test
    void areAnagramShouldBeTrue() {
        boolean response = anagramService.areAnagram("Mother in law", "Hitler woman");
        assertTrue(response);
    }

    @Test
    void areAnagramShortShouldBeTrue() {
        boolean response = anagramService.areAnagram("haha", "ahah");
        assertTrue(response);
    }

    @Test
    void areAnagramSpacesShouldBeTrue() {
        boolean response = anagramService.areAnagram("debitcard", "bad credit");
        assertTrue(response);
    }

    @Test
    void areAnagramCaseShouldBeTrue() {
        boolean response = anagramService.areAnagram("indicatory", "Dictionary");
        assertTrue(response);
    }
}