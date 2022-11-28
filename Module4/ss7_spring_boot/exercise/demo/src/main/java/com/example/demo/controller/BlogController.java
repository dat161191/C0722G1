package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    @Autowired
    public BlogController(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }

    /*========Display and search===========*/
    @GetMapping("")
    public String display(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Category category = new Category();
        model.addAttribute("search", search);
        model.addAttribute("category", category);
        model.addAttribute("blogList", iBlogService.findByBlogNameContainingOrAuthorContainingOrderByAuthor(search, pageable));
        return "/blog/list";
    }

    /*=========CREATE==========*/
    @GetMapping("/create")
    public String showListCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Add Success");
        return "redirect:/";
    }




    /*===========EDIT==============*/

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit Success");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteConfirm") Integer id, RedirectAttributes redirectAttributes) {
        iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Success");
        return "redirect:/";
    }

    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Add Success");
        return "redirect:/";
    }
}
