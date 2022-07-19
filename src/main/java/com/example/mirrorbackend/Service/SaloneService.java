package com.example.mirrorbackend.Service;

import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class SaloneService {
    private final SalonServiceRepository salonServiceRepository;

    public List<SalonService> findAllServices(){
        return salonServiceRepository.findAll();
    }
    public SalonService getService(String id){
        return salonServiceRepository.findById(id).get();
    }
    public void createService(SalonService salonService){
        salonServiceRepository.save(salonService);
    }
    public void deleteService(String id){
        salonServiceRepository.deleteById(id);
    }
    public void addRequestToService(ServiceRequest serviceRequest, SalonService salonService){
        salonService.getServiceRequests().add(serviceRequest);
        salonServiceRepository.save(salonService);
    }
    public void setChosenPrice(Double chosenPrice, SalonService salonService){
        salonService.setChosenPrice(chosenPrice);
        salonServiceRepository.save(salonService);
    }


}
