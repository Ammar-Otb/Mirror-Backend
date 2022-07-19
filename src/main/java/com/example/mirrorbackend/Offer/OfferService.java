package com.example.mirrorbackend.Offer;

import com.example.mirrorbackend.ServiceRequest.RequestSerivce;
import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;


    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public void addOffer(Offer offer) {
        offerRepository.save(offer);
    }

    public Offer getOffer(String offerId) {
        return offerRepository.findById(offerId).get(); // possible throw some error handling here

    }



}
