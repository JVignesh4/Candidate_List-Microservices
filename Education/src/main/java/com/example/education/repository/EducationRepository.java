package com.example.education.repository;

import com.example.education.model.EducationDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationDetailsData, Integer> {

}

