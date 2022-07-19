package com.example.mirrorbackend.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class CustomerSerivce {
    private final CustomerRepository customerRepository;
    public List<Customer> getAllUsers(){
        return customerRepository.findAll();
    }
    public void registerCustomer(Customer customer){
        String hashedPassword= new BCryptPasswordEncoder().encode(customer.getPassword());
        customer.setPassword(hashedPassword);
        customerRepository.save(customer);
    }

    public Customer getCustomer(String customerId){
        return customerRepository.findById(customerId).get();
    }

    public Customer findMyUserByUsername(String phoneNumber) {
       Optional<Customer> customer= customerRepository.findCustomerByUsername(phoneNumber);
        if(customer.isEmpty()){
            throw new UsernameNotFoundException("Number not found");
        }
        return customer.get();
    }
}
