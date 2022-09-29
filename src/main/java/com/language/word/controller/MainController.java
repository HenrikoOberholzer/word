package com.language.word.controller;

import com.language.word.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 Created by Henriko on 2022/09/29
*/
@Controller
public class MainController {

    @Autowired
    private AnagramService anagramService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("result", "false");
        return "home";
    }

    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String save(Model model, @RequestParam String currentWord, @RequestParam String possibleAnagram) {
        model.addAttribute("result", anagramService.areAnagram(currentWord, possibleAnagram));

        return "home";
    }
}
