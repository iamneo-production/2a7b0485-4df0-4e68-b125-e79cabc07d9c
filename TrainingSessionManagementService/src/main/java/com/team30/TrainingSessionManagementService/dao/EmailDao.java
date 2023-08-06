package com.team30.TrainingSessionManagementService.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDao {
    private List<Surgeon> surgeons;

    private String subject;
    private String message;
}
