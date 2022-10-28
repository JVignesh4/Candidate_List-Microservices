package com.example.candidate.service;

import com.example.candidate.dto.CandidateDTO;
import com.example.candidate.model.CandidateData;

import java.util.List;

public interface ICandidateService {

    String createCandidate(CandidateDTO candidateDTO);
    CandidateData viewProfile(String token);

    Long countOfHired(String status);

    List<CandidateData> listOfHired(String status);

    void deleteCandidate(int id);
}
