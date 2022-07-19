package com.example.mirrorbackend.Service;

import com.example.mirrorbackend.API.API;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequiredArgsConstructor @RequestMapping("api/v1/service")
public class SalonServiceController {
    private final SaloneService saloneService;

    @GetMapping
    public ResponseEntity getAllServices(){
        return ResponseEntity.ok(saloneService.findAllServices());
    }
    @GetMapping("{id}")
    public ResponseEntity getService(@PathVariable String id){
        if(saloneService.getService(id) == null){
            return ResponseEntity.badRequest().body(new API("Invalid Service ID", 401));
        }
        return ResponseEntity.ok(saloneService.getService(id));
    }
    @PutMapping("/{chosenPrice}/{serviceId}")
    public ResponseEntity setChosenPrice(@PathVariable String serviceId,
                                         @PathVariable Double chosenPrice){
        saloneService.setChosenPrice(chosenPrice, saloneService.getService(serviceId));
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Price set", 201));
    }
    @PostMapping()
    public ResponseEntity createService(@RequestBody @Valid SalonService salonService){
        if(salonService == null){return ResponseEntity.badRequest().body(new API("Invalid Data Entered", 401));}
        saloneService.createService(salonService);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Created Service", 201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteService(@PathVariable String id){
        if(saloneService.getService(id) == null){
            return ResponseEntity.badRequest().body(new API("Invalid Service ID", 401));
        }
        return ResponseEntity.ok(saloneService.getService(id));
    }

}
