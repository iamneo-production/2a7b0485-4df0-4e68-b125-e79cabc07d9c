package com.team30.authentication.controller;

import com.team30.authentication.entity.Surgeon;
import com.team30.authentication.model.Surgery;
import com.team30.authentication.service.SurgeonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/surgeon")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${virtual-environment-service.base-url}")
    private String urlOfVirtualEnvironment;

    @GetMapping("/remote/get-surgeon")
    List<Surgeon> getSurgeons(){
        return surgeonService.getSurgeons();
    }

    @PostMapping("/remote/create-virtualization/{patientId}/{surgeryName}")
    Surgery createVirtualEnvironment(@PathVariable String patientId, @PathVariable String surgeryName){
        log.info("p-id: {} ,surgeryName: {}",patientId,surgeryName);
        Surgery surgery = Surgery.builder()
                .patientID(patientId)
                .surgeryName(surgeryName)
                .build();
        // calling virtual-env url
        String uri = urlOfVirtualEnvironment+"/virtual-environment";
        Surgery fetchedSurgeryDetails = restTemplate.postForEntity(uri, surgery, Surgery.class).getBody();

        return fetchedSurgeryDetails;
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
