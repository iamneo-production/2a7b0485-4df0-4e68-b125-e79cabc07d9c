package com.team30.TrainingSessionManagementService.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Surgeon {

    private String firstName;
    private String lastName;

    private String email;

    private String role;
}
