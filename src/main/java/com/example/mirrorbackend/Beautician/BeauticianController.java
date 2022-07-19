package com.example.mirrorbackend.Beautician;


import com.example.mirrorbackend.API.API;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/beautician")
public class BeauticianController {

    private final BeauticianService beauticianService;


    //get all beauticians
    @GetMapping
    public ResponseEntity<List<Beautician>> getBeauticians(){
        return ResponseEntity.status(HttpStatus.OK).body(beauticianService.getBeauticians());

    }

    // get beautician by specific id
    @GetMapping({"btId"})          // singular
    public ResponseEntity getBeautician(@PathVariable String btId){
        // check if null or not
        if(beauticianService.getBeautician(btId) == null){
            return ResponseEntity.status(400).body(new API("beautician not found or does not  exist check Id",400));
        }

        return ResponseEntity.status(HttpStatus.OK).body(beauticianService.getBeautician(btId));


    }







    @PostMapping("/register")
    public ResponseEntity<API>addBeauticians(@RequestBody @Valid Beautician beautician){
        // for now w/o principles
        beauticianService.addBeauticians(beautician);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("beautician Registered",201));

    }






}
