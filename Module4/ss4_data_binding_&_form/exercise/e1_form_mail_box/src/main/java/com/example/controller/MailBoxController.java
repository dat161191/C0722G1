package com.example.controller;

import com.example.model.Mailbox;
import com.example.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class MailBoxController {
    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping("")
    public String Index(Model model) {
        List<Mailbox> mailboxList=iMailBoxService.fileAll();
        model.addAttribute("mailboxList",mailboxList);
        return "index";
    }

    @GetMapping("/formEdit")
    public String showEdit(@RequestParam("id") int id, ModelMap modelMap) {
        Mailbox mailbox = iMailBoxService.findById(id);
        List<String> languagesList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSizeList =Arrays.asList(5,10,15,20,25);
        modelMap.addAttribute("mailbox", mailbox);
        modelMap.addAttribute("languagesList", languagesList);
        modelMap.addAttribute("pageSizeList", pageSizeList);
        return "edit";
    }
    @PostMapping("update")
    public String edit(@RequestParam Mailbox mailbox, RedirectAttributes redirectAttributes){
        iMailBoxService.update(mailbox);
        redirectAttributes.addFlashAttribute("mess","Update success");
        return "redirect:/";
    }
}
