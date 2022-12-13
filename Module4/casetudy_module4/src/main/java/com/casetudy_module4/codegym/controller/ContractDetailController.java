package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.contact_dto.ContractDetailDto;
import com.casetudy_module4.codegym.model.contact.ContractDetail;
import com.casetudy_module4.codegym.service.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @PostMapping("create")
    public String create(@ModelAttribute("contractDto") ContractDetailDto contractDetailDto, RedirectAttributes redirectAttributes){
        ContractDetail contractDetail=new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        redirectAttributes.addFlashAttribute("notice", 1);
        contractDetailService.save(contractDetail);
        return "redirect:/contract/";
    }

}
