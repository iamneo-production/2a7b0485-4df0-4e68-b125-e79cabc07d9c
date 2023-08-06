package com.mshackathon.patientservice.controller;

import com.mshackathon.patientservice.dto.PatientRequestDto;
import com.mshackathon.patientservice.dto.PatientResponseDto;
import com.mshackathon.patientservice.model.Patient;
import com.mshackathon.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDto> getPatientByPatientId(@PathVariable("patientId") Long patientId){
        return new ResponseEntity<>(patientService.getPatientByPatientId(patientId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePatient(@RequestBody PatientRequestDto patientRequestDto){
        patientService.savePatient(patientRequestDto);
        return new ResponseEntity<>("Patient saved successfully",HttpStatus.CREATED);
    }
}
