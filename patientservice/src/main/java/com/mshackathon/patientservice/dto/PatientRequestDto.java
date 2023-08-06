package com.mshackathon.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDto {

    private String patientName;
    private int patientAge;
    private String patientDescription;
}
