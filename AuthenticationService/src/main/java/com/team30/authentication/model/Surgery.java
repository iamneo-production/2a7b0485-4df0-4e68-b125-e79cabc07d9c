package com.team30.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Surgery {
    private String patientID;
    private String surgeryName;
    private String surgeryStatus;
    private String surgeryDesc;
}
