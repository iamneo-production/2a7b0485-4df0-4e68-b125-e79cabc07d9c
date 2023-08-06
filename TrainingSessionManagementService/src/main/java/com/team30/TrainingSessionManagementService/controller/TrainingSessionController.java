package com.team30.TrainingSessionManagementService.controller;

import com.team30.TrainingSessionManagementService.dao.EmailDao;
import com.team30.TrainingSessionManagementService.dao.Surgeon;
import com.team30.TrainingSessionManagementService.service.TraningSessionService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/Training")
public class TrainingSessionController {

    @Autowired
    private TraningSessionService traningSessionService;

    @PostMapping("/notifyTrainees")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDao emailDao){
        List<Surgeon> trainees = emailDao.getSurgeons().stream().filter(surgeon -> surgeon.getRole().equals("ROLE_SURGEON_TRAINEE")).collect(Collectors.toList());
        for (Surgeon trainee: trainees) {
            if(!traningSessionService.sendEmail(emailDao.getSubject(),emailDao.getMessage(),trainee.getEmail())){
                log.error("message sent was unsuccessful for trainee -> "+trainee.toString());
            }

        }
        return ResponseEntity.ok("notified to trainees");
    }
}
