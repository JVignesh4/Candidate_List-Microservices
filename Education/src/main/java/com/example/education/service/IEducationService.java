package com.example.education.service;

import com.example.education.dto.EducationDTO;
import com.example.education.model.EducationDetailsData;

public interface IEducationService {


    String addEducationDetails(EducationDTO educationDTO);

    EducationDetailsData viewEducationDetails(String token);

    EducationDetailsData updateEducationDetails(int id, EducationDTO educationDTO);
}
