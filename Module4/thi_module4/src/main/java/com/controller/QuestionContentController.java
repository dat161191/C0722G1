package com.controller;

import com.dto.QuestionContentDto;
import com.model.QuestionContent;
import com.model.QuestionType;
import com.service.IQuestionContentService;
import com.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuestionContentController {
    private IQuestionContentService questionContentService;
    private IQuestionTypeService questionTypeService;

    @Autowired
    public QuestionContentController(IQuestionContentService questionContentService, IQuestionTypeService questionTypeService) {
        this.questionContentService = questionContentService;
        this.questionTypeService = questionTypeService;
    }

    @ModelAttribute("questionTypeList")
    public List<QuestionType> questionTypeList() {
        return questionTypeService.findAll();
    }

    @GetMapping("")
    public String display(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "-1") int questionTypeid, @PageableDefault(page = 0, size = 2) Pageable pageable, Model model) {
        if (questionTypeid != -1) {
            QuestionType questionType = questionTypeService.findById(questionTypeid);
            model.addAttribute("questionContentList", questionContentService.findByTitleContainingAndQuestionType(title, questionType, pageable));
        } else {
            model.addAttribute("questionContentList", questionContentService.findByTitleContaining(title, pageable));
        }
        model.addAttribute("questionTypeid", questionTypeid);
        model.addAttribute("title", title);
        return "/list";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer deleteId, @RequestParam("deleteName2") String deleteName2, RedirectAttributes redirectAttributes) {
        questionContentService.delete(deleteId);
        redirectAttributes.addFlashAttribute("deleteAlert", 1);
        redirectAttributes.addFlashAttribute("deleteName2", deleteName2);
        return "redirect:/";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        QuestionContentDto questionContentDto = QuestionContentDto.builder().build();
        model.addAttribute("questionContentDto", questionContentDto);
        return "/create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("questionContentDto") QuestionContentDto questionContentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        QuestionContent questionContent = QuestionContent.builder().build();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        questionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("createAlert", 1);
        return "redirect:/";
    }
}
