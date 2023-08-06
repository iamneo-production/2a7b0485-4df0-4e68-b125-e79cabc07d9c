package com.example.demo.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
 
// Annotations
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
 
// Class
public class Sergery {
 

    private String patainetID;
    private String sergery_name;
    private String sergery_status;
    private String sergery_desc;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sergery_id;
}
