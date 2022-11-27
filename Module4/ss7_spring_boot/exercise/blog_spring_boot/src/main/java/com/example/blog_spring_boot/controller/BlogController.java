package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @RequestMapping("")
    public String showListBlog(@RequestParam(defaultValue = "") String search, Model model) {
        List<Blog> blogList = blogService.findByAuthorContainingOrContentContainingOrTitleContaining(search);
        model.addAttribute("blogList", blogList);
        model.addAttribute("search", search);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "/blog/edit";
        } else {
            return "/blog/error.404";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }

}
