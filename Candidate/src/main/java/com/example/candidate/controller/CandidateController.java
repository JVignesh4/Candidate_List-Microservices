package com.example.candidate.controller;

import com.example.candidate.dto.CandidateDTO;
import com.example.candidate.dto.ResponseDTO;
import com.example.candidate.model.CandidateData;
import com.example.candidate.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCandidate(@Valid @RequestBody CandidateDTO candidateDTO) {
        String candidateData =candidateService.createCandidate(candidateDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Candidate Data Successfully", candidateData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getby/{token}")
    public ResponseEntity<ResponseDTO> viewProfile(@PathVariable String token){
        CandidateData candidateData = candidateService.viewProfile(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", candidateData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/count/{status}")
    public ResponseEntity<ResponseDTO> countOfHired(@PathVariable String status){
        long candidateData = candidateService.countOfHired(status);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", candidateData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/list/{status}")
    public ResponseEntity<ResponseDTO> listOfHired(@PathVariable String status){
        List<CandidateData> candidateData = candidateService.listOfHired(status);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", candidateData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteCandidate(@PathVariable int id){
        candidateService.deleteCandidate(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
