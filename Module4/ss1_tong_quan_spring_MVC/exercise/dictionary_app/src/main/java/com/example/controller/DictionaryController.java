package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String dictionary(){
        return "dictionary";
    }
    @PostMapping("/find")
    public String search(String enWord, Model model) {
        String result = dictionaryService.getViWord(enWord);
        model.addAttribute("viWord","Kết quả: " + result);
        return "dictionary";
    }
}
