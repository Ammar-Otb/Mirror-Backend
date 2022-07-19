package com.example.mirrorbackend.ServiceRequest;

import com.example.mirrorbackend.Customer.Customer;
import com.example.mirrorbackend.Offer.Offer;
import com.example.mirrorbackend.Service.SalonService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
@Table(name = "service_request")
public class ServiceRequest {
    @Id
    private String serviceRequestId = UUID.randomUUID().toString().toUpperCase();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "request_service_table",
            joinColumns = @JoinColumn(
                    name = "request_id",
                    referencedColumnName = "serviceRequestId"
            ),
            inverseJoinColumns =@JoinColumn(
                    name = "service_id ",
                    referencedColumnName = "salonServiceId")
    )
    private Set<SalonService> services;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "request_offer_table",
            joinColumns = @JoinColumn(
                    name = "request_id",
                    referencedColumnName = "serviceRequestId"
            ),
            inverseJoinColumns =@JoinColumn(
                    name = "offer_id ",
                    referencedColumnName = "id")
    )
    private Set<Offer> offers;
    @NotNull
    private String address;

    private Double total= 0.0;

}