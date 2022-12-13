package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.contact_dto.ContractDetailDto;
import com.casetudy_module4.codegym.dto.contact_dto.ContractDto;
import com.casetudy_module4.codegym.dto.contact_dto.ContractDtoList;
import com.casetudy_module4.codegym.model.contact.AttachFacility;
import com.casetudy_module4.codegym.model.contact.Contract;
import com.casetudy_module4.codegym.model.contact.ContractDetail;
import com.casetudy_module4.codegym.service.*;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("contract")
public class ContractController {
    private IContractDetailService contractDetailService;
    private IContractService contractService;
    private IAttachFacilityService attachFacilityService;
    private IEmployeeService employeeService;
    private ICustomerService customerService;
    private IFacilityService facilityService;

    public ContractController(IContractDetailService contractDetailService, IContractService contractService, IAttachFacilityService attachFacilityService, IEmployeeService employeeService, ICustomerService customerService, IFacilityService facilityService) {
        this.contractDetailService = contractDetailService;
        this.contractService = contractService;
        this.attachFacilityService = attachFacilityService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.facilityService = facilityService;
    }

    @GetMapping("")
    public String showList(@PageableDefault(page = 0,size = 5)Pageable pageable, Model model){
        model.addAttribute("contractDtoList",contractService.showListContract(pageable));
        model.addAttribute("contractDetailList",contractDetailService.findAll());
        model.addAttribute("attachList",attachFacilityService.findAll());
        model.addAttribute("contractDetail", ContractDetail.builder().build());
        model.addAttribute("attachFacility", AttachFacility.builder().build());
        model.addAttribute("contractDto", ContractDto.builder().build());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("facilityList",facilityService.findAll());
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "contract/list";
    }
    @PostMapping("create")
    public String create(@ModelAttribute("contractDto") ContractDto contractDto, RedirectAttributes redirectAttributes){
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        redirectAttributes.addFlashAttribute("notice", 1);
        contractService.save(contract);
        return "redirect:/contract/";
    }
}
