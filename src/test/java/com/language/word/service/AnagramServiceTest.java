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
    void areAnagramShouldBeTrue() {
        boolean response = anagramService.areAnagram("Mother in law", "Hitler woman");
        assertFalse(response);
    }
}