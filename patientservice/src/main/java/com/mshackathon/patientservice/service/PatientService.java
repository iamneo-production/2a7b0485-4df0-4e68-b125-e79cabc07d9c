package com.mshackathon.patientservice.service;

import com.mshackathon.patientservice.dto.PatientRequestDto;
import com.mshackathon.patientservice.dto.PatientResponseDto;

public interface PatientService {

    public void savePatient(PatientRequestDto patientRequestDto);

    public PatientResponseDto getPatientByPatientId(Long patientId);
}
