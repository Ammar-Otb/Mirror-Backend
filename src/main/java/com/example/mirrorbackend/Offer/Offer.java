package com.example.mirrorbackend.Offer;

import com.example.mirrorbackend.Report.Report;
import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Offer {

    @Id
    private String Id = UUID.randomUUID().toString().toUpperCase();

//    @NotNull(message = "Status Is Required")
    private Boolean status = false;

    @Positive
    private Double offeredPrice;


    @ManyToMany(mappedBy = "offers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ServiceRequest> serviceRequests;

    @OneToOne (mappedBy = "offer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Report report ;

}
