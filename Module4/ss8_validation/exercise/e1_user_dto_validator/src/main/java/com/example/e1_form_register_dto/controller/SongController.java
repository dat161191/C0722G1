package com.example.e1_form_register_dto.controller;

import com.example.e1_form_register_dto.dto.SongDto;
import com.example.e1_form_register_dto.model.Song;
import com.example.e1_form_register_dto.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Pageable pageable, Model model){
        Page<Song> songList = songService.findAll(pageable);
        model.addAttribute("songList", songList);
        return "/list";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Song> song = songService.findById(id);
            model.addAttribute("songDto", song.get());
            return "/edit";
    }
    @PostMapping("edit")
    public String edit(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Edit success!");
        return "redirect:/";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        return "/create";
    }
    @PostMapping("create")
    public String save(@Validated @ModelAttribute("songDto")SongDto songDto, BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Song is added successfully");
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Integer id, RedirectAttributes redirectAttributes) {
        songService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }
}
