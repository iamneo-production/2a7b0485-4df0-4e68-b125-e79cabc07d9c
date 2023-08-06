package com.example.demo.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
 
@RestController
public class VirtualEnvironmentManagementController {
 
    @Autowired 
    private VirtualEnvironmentManagementService environmentManagementService;
 
    
    @PostMapping("/virtual-environment")
    public Sergery createVirtualSergicalDetails(
        @Validated @RequestBody Sergery sergery)
    {
         return environmentManagementService.createVirtualSergicalDetails(sergery);
    }
   
}
