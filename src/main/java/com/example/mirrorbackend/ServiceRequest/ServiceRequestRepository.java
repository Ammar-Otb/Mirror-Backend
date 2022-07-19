package com.example.mirrorbackend.ServiceRequest;

import com.example.mirrorbackend.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, String> {
    @Query("select c from ServiceRequest c where c.customer.customerId=?1")
    List<ServiceRequest> findAllByCustomer(String customerId);
}