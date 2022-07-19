package com.example.mirrorbackend.Service;

import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "salonService") @AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SalonService {
    public Double ChosenPrice = 0.0;
    @Id
    private String salonServiceId = UUID.randomUUID().toString().toUpperCase();

    @NotNull(message = "Service Name must be entered!")
    private String serviceName;

    @NotNull(message = "Please enter a maximum price")
    private Double serviceMaxPrice;

    @NotNull(message = "Please enter a minimum price")
    private Double serviceMinPrice;

    @NotNull(message = "Please enter the description")
    private String description;

    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ServiceRequest> serviceRequests;
}
