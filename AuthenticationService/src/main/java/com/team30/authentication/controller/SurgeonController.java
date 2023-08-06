package com.team30.authentication.controller;

import com.team30.authentication.entity.Surgeon;
import com.team30.authentication.service.SurgeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeon")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;

    @GetMapping("/remote/get-surgeon")
    List<Surgeon> getSurgeons(){
        return surgeonService.getSurgeons();
    }
    @GetMapping("/remote/get-name")
    String getSurgeonName(){
        return "Remote Surgeon";
    }

    @GetMapping("/trainee/get-name")
    String tarinee1(){
        return "Trainee Surgeon";
    }
    @GetMapping("/trainee/get-d")
    String tarinee2(){
        return "Trainee Surgeon Dr";
    }


}
