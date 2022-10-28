package com.example.education.model;
import com.example.education.dto.EducationDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="education_details")
public class EducationDetailsData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String degree;
    private String passedOut;
    private String percentage;

    public EducationDetailsData(EducationDTO educationDTO) {
        this.degree = educationDTO.getDegree();
        this.passedOut = educationDTO.getPassedOut();
        this.percentage = educationDTO.getPercentage();
    }

    public EducationDetailsData() {

    }
}

