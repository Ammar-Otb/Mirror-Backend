package com.example.mirrorbackend.Offer;

import com.example.mirrorbackend.API.API;
import com.example.mirrorbackend.ServiceRequest.RequestSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/offer")
public class OfferController {

    private final OfferService offerService ;
    private final RequestSerivce requestSerivce;



    @GetMapping
    public ResponseEntity<List<Offer>> getOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getOffers());
    }


    @PostMapping("/{requestId}")
    public ResponseEntity<API> addOffer(@RequestBody @Valid Offer offer, @PathVariable String requestId){
        // for now w/o principles
        requestSerivce.addOfferToRequest(requestId,offer);
         return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Offer Added" ,201));
    }

    //get offer by id
    @GetMapping({"/{offerId}"}) // offer in singular
    public ResponseEntity getOffer(@PathVariable String offerId){
        // check if null or not
        if(offerService.getOffer(offerId) == null){
            return ResponseEntity.status(400).body(new API("offer not found or does not exist check Id",400));
        }
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getOffer(offerId));

    }
    @PutMapping("/accept/offer/{offerId}")
    public ResponseEntity acceptOffer(@PathVariable String offerId){
        requestSerivce.acceptOffer(offerId);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Accepted", 201));
    }



}
