package com.example.blog_modal.controller;


import com.example.blog_modal.model.Blog;
import com.example.blog_modal.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    private IBlogService iBlogService;

    @Autowired
    public BlogController(IBlogService iBlogService) {
        this.iBlogService = iBlogService;
    }

    /*========Display and search===========*/
    @GetMapping("")
    public String display(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        model.addAttribute("search", search);
        model.addAttribute("blogList", iBlogService.findByBlogNameContainingOrAuthorContainingOrderByAuthor(search, pageable));
        return "/list";
    }
    /*=========CREATE==========*/

    @PostMapping("/create")
    public String save(@RequestParam("blogName") String blogName
            , @RequestParam("content") String content, @RequestParam("author") String author, @RequestParam("dateWriting") String dateWriting, RedirectAttributes redirect) {
        Blog blog = new Blog(blogName, content, author, dateWriting);
        iBlogService.save(blog);
        redirect.addFlashAttribute("message", "Add Success");
        return "redirect:/";
    }


    /*===========EDIT==============*/

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id, @RequestParam("blogName") String blogName
            , @RequestParam("content") String content, @RequestParam("author") String author, @RequestParam("dateWriting") String dateWriting, RedirectAttributes redirectAttributes) {
        Blog blog = new Blog(id, blogName, content, author, dateWriting);
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer deleteConfirm, RedirectAttributes redirectAttributes) {
        iBlogService.remove(deleteConfirm);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }
}
