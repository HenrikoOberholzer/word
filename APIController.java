package com.language.word.controller;

import com.language.word.dto.AnagramRequest;
import com.language.word.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 Created by Henriko on 2022/09/30 
*/
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private AnagramService anagramService;

    @PostMapping(path = "/anagram", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Boolean> save(@RequestBody AnagramRequest anagramRequest) {
        boolean result = anagramService.areAnagram(anagramRequest.getCurrentWord(), anagramRequest.getPossibleAnagram());
        return ResponseEntity.ok(result);
    }
}
