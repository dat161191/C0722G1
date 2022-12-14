package com.casetudy_module4.codegym.controller;

import com.casetudy_module4.codegym.dto.contact_dto.AttachFacilityDto;
import com.casetudy_module4.codegym.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("attach-facility")
@CrossOrigin("*")
public class AttachFacilityController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("show/{id}")
    public ResponseEntity<List<AttachFacilityDto>> showListAttach(@PathVariable("id") Long id) {
        List<AttachFacilityDto> attachFacilityDtoList = attachFacilityService.showListAttach(id);
        if (attachFacilityDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }
}
