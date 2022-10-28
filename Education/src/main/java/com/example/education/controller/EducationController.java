package com.example.education.controller;

import com.example.education.dto.EducationDTO;
import com.example.education.dto.ResponseDTO;
import com.example.education.model.EducationDetailsData;
import com.example.education.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private IEducationService educationService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEducationDetails(@Valid @RequestBody EducationDTO educationDTO) {
        String educationData =educationService.addEducationDetails(educationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Education Data Successfully", educationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getby/{token}")
    public ResponseEntity<ResponseDTO> viewDetails(@PathVariable String token){
        EducationDetailsData detailsData = educationService.viewEducationDetails(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully ", detailsData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateData(@PathVariable int Id,@Valid @RequestBody EducationDTO educationDTO){
        EducationDetailsData detailsData = educationService.updateEducationDetails(Id,educationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", detailsData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

