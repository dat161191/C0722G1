package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.facility_dto.FacilityDto;
import com.casetudy_module4.codegym.model.facility.Facility;
import com.casetudy_module4.codegym.model.facility.FacilityType;
import com.casetudy_module4.codegym.model.facility.RentType;
import com.casetudy_module4.codegym.service.IFacilityService;
import com.casetudy_module4.codegym.service.IFacilityTyeService;
import com.casetudy_module4.codegym.service.IRentTypeService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("facility")
public class FacilityController {
    private final IFacilityService facilityService;
    private final IFacilityTyeService facilityTyeService;
    private final IRentTypeService rentTypeService;

    public FacilityController(IFacilityService facilityService, IFacilityTyeService facilityTyeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTyeService = facilityTyeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public String home(@RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "-1") int searchFacilityType, @PageableDefault(page = 0, size = 4) Pageable pageable, Model model) {
        if (searchFacilityType != -1) {
            FacilityType facilityType = facilityTyeService.findById(searchFacilityType);
            model.addAttribute("facilityList", facilityService.findByNameContainingAndFacilityTypeOrderByName(searchName, facilityType, pageable));
        } else {
            model.addAttribute("facilityList", facilityService.findByNameContainingOrderByName(searchName, pageable));
        }
        model.addAttribute("facilityTypeList", facilityTyeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityDto", FacilityDto.builder().build());
        model.addAttribute("facilityType", new FacilityType());
        model.addAttribute("rentType", new RentType());
        model.addAttribute("searchName", searchName);
        return "facility/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam Integer deleteId, RedirectAttributes redirectAttributes) {
        facilityService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess", "Delete success!!!");
        return "redirect:/facility/";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("facility", Facility.builder().build());
        model.addAttribute("facilityDto", FacilityDto.builder().build());
        model.addAttribute("facilityTypeList", facilityTyeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = Facility.builder().build();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Create success!!!");
        return "redirect:/facility/";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model) {
//        Facility facility=facilityService.findById(id);
//        FacilityDto facilityDto=FacilityDto.builder().build();
//        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facility", facilityService.findById(id));
//        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("facilityTypeList", facilityTyeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/edit";
    }
    @PostMapping("edit")
    public String Edit(@ModelAttribute("facility") Facility facility,RedirectAttributes redirectAttributes ){
//    public String Edit(@ModelAttribute("facilityDto") FacilityDto facilityDto,RedirectAttributes redirectAttributes ){
//        Facility facility=Facility.builder().build();
//        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Edit Success!!!");
        return "redirect:/facility/";
    }
}

