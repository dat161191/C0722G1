package com.example.song_validation.controller;

import com.example.song_validation.model.Song;
import com.example.song_validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService<Song> songService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "/home";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "add";
    }

    @PostMapping("/add")
    public String addSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Added new Song");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Song Edited");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String removeSong(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        songService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Song Removed");
        return "redirect:/";
    }

}
