package com.mshackathon.patientservice.serviceimpl;

import com.mshackathon.patientservice.dao.PatientRepository;
import com.mshackathon.patientservice.dto.PatientRequestDto;
import com.mshackathon.patientservice.dto.PatientResponseDto;
import com.mshackathon.patientservice.exceptions.PatientNotFoundException;
import com.mshackathon.patientservice.model.Patient;
import com.mshackathon.patientservice.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void savePatient(PatientRequestDto patientRequestDto) {
        log.info("Patient request = {}",patientRequestDto);
        Patient patient = this.modelMapper.map(patientRequestDto,Patient.class);
        this.patientRepository.save(patient);
        log.info("Patient details was saved successfully");
    }

    @Override
    public PatientResponseDto getPatientByPatientId(Long patientId) {
        Patient patient = this.patientRepository.findById(patientId).orElseThrow(()-> new PatientNotFoundException("No patient found with given id"));
        PatientResponseDto patientResponseDto = this.modelMapper.map(patient,PatientResponseDto.class);
        return patientResponseDto;
    }
}
