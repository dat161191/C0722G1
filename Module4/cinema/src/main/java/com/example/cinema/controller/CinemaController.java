package com.example.cinema.controller;

import com.example.cinema.dto.CinemaDto;
import com.example.cinema.model.Cinema;
import com.example.cinema.model.NameMovie;
import com.example.cinema.service.ICinemaService;
import com.example.cinema.service.INameMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CinemaController {
    private ICinemaService cinemaService;
    private INameMovieService nameMovieService;


    @Autowired
    public CinemaController(ICinemaService cinemaService, INameMovieService nameMovieService) {
        this.cinemaService = cinemaService;
        this.nameMovieService = nameMovieService;
    }

    @ModelAttribute("nameMovieList")
    public List<NameMovie> nameMovieList() {
        return nameMovieService.findAll();
    }

    @GetMapping("")
    public String display(@RequestParam(defaultValue = "-1") int nameMovieid, @RequestParam(defaultValue = "") String date, @PageableDefault(page = 0, size = 2) Pageable pageable, Model model) {
        if (nameMovieid != -1) {
            NameMovie nameMovie = nameMovieService.findById(nameMovieid);
            model.addAttribute("cinemaList", cinemaService.findByNameMovieAndDateContains(nameMovie, date, pageable));
        } else {
            model.addAttribute("cinemaList", cinemaService.findByDateContains(date, pageable));
        }
        model.addAttribute("nameMovieid", nameMovieid);
        model.addAttribute("date", date);
        model.addAttribute("cinema", Cinema.builder().build());//dùng cho modal
        return "/list";
    }
    /*Delete*/
    @PostMapping("delete")
    public String delete(@RequestParam Integer deleteId, @RequestParam("deleteName2") String deleteName2, RedirectAttributes redirectAttributes) {
        cinemaService.delete(deleteId);
        redirectAttributes.addFlashAttribute("deleteAlert", 1);
        redirectAttributes.addFlashAttribute("deleteName2", deleteName2);
        return "redirect:/";
    }

    /*Create*/
    @GetMapping("create")
    public String showCreate(Model model) {
        Cinema cinema = Cinema.builder().build();
        model.addAttribute("cinema", cinema);
        model.addAttribute("cinemaDto", CinemaDto.builder().build());
        return "/create";
    }

    @PostMapping("create")
    public String add(@Validated @ModelAttribute("cinemaDto") CinemaDto cinemaDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CinemaDto().validate(cinemaDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Cinema cinema=Cinema.builder().build();
        BeanUtils.copyProperties(cinemaDto,cinema);
        cinemaService.save(cinema);
        redirectAttributes.addFlashAttribute("createAlert", 1);
        return "redirect:/";
    }

    @PostMapping("create-modal")
    public String create(@ModelAttribute("cinema") Cinema cinema, RedirectAttributes redirectAttributes) {
        cinemaService.save(cinema);
        redirectAttributes.addFlashAttribute("createAlert", 1);

        return "redirect:/";
    }

    /*Edit*/
    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
        Cinema cinema = cinemaService.findByID(id);
        CinemaDto cinemaDto=CinemaDto.builder().build();
        BeanUtils.copyProperties(cinema,cinemaDto);
        model.addAttribute("cinemaDto", cinemaDto);
        return "edit";
    }

    @PostMapping("edit")
    public String update(@Validated @ModelAttribute("cinemaDto") CinemaDto cinemaDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CinemaDto().validate(cinemaDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Cinema cinema=Cinema.builder().build();
        BeanUtils.copyProperties(cinemaDto,cinema);
        cinemaService.save(cinema);
        redirectAttributes.addFlashAttribute("editAlert", 1);
        return "redirect:/";
    }

    @PostMapping("edit-modal")
    public String edit(@ModelAttribute("cinema") Cinema cinema, RedirectAttributes redirectAttributes) {
        cinemaService.save(cinema);
        redirectAttributes.addFlashAttribute("editAlert", 1);
        return "redirect:/";
    }

}
