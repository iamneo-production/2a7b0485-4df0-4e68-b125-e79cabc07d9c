package com.example.demo.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
 
// Class
public class VirtualEnvironmentManagementServiceImpl
    implements VirtualEnvironmentManagementService{
 
    @Autowired
    private VirtualEnvironmentManagementRepository environmentManagementRepository;
 
    @Override
    public Sergery createVirtualSergicalDetails(Sergery sergeryDetails)
    {
        Sergery sergery=new Sergery();
        sergery.setPatainetID(sergeryDetails.getPatainetID());
        sergery.setSergery_desc(sergeryDetails.getSergery_desc());
        sergery.setSergery_name(sergeryDetails.getSergery_name());
        sergery.setSergery_status(sergeryDetails.getSergery_status());
        sergery.setSergery_id(sergeryDetails.getSergery_id());
        return environmentManagementRepository.save(sergery);
    }
    
}
