package com.example.education.service;
import com.example.education.dto.EducationDTO;
import com.example.education.exception.CandidateEducationException;
import com.example.education.model.EducationDetailsData;
import com.example.education.repository.EducationRepository;
import com.example.education.util.EmailSenderService;
import com.example.education.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EducationService implements IEducationService {


    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private EmailSenderService mailService;
    @Autowired
    private TokenUtil util;

    @Override
    public String addEducationDetails(EducationDTO educationDTO) {
        EducationDetailsData detailsData = new EducationDetailsData(educationDTO);
        educationRepository.save(detailsData);
        String token = util.createToken(detailsData.getId());
        mailService.sendEmail("vigneshjmax@gmail.com", "Education details Added", "Education details added Successfully, "
                + detailsData.getDegree() + " " + token);

        return token;
    }

    @Override
    public EducationDetailsData viewEducationDetails(String token) {
        int id = util.decodeToken(token);
        Optional<EducationDetailsData> getUser = educationRepository.findById(id);
        if (getUser.isPresent()) {
            mailService.sendEmail("Vigneshjmax@gmail.com", "Test Email", "Get Your Data With This Token "
                    + getUser.get() + " " + token);

            return getUser.get();
        } else {
            throw new CandidateEducationException("Record For Provided UserId Is Not Found");
        }
    }

    @Override
    public EducationDetailsData updateEducationDetails(int id, EducationDTO educationDTO) {
        Optional<EducationDetailsData> educationData = educationRepository.findById(id);
        if (educationData.isEmpty()) {
            throw new CandidateEducationException("Details doesn't exist");
        } else {
            EducationDetailsData newData = new EducationDetailsData(educationDTO);
            educationRepository.save(newData);
            log.info("Education Details updated successfully");
            return newData;
        }
    }
}
