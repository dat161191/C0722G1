package com.example.app_blog_spring_boot.controller;

import com.example.app_blog_spring_boot.model.Blog;
import com.example.app_blog_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {

    private IBlogService iBlogService;
    @Autowired
    public BlogController(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }
    /*========Display and search===========*/
    @GetMapping("")

    public String display(@RequestParam(defaultValue = "") String search, Model model){
        model.addAttribute("search",search);
        model.addAttribute("blogList",iBlogService.findByBlogNameOrAuthorContaining(search));
        return "/list";
    }
    /*=========CREATE==========*/
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("message", "Add Success");
        return "redirect:/";
    }


    /*===========EDIT==============*/
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int deleteConfirm, RedirectAttributes redirectAttributes) {
        iBlogService.remove(deleteConfirm);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }
}
