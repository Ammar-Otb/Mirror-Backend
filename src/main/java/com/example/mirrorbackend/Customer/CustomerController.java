package com.example.mirrorbackend.Customer;

import com.example.mirrorbackend.API.API;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor @RequestMapping("api/v1/customer/")
public class CustomerController {
    private final CustomerSerivce customerSerivce;

    @GetMapping()
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(customerSerivce.getAllUsers());
    }
    @GetMapping("/customer")
    public ResponseEntity getCustomer(@AuthenticationPrincipal Customer customer){
        if(customerSerivce.getCustomer(customer.getCustomerId()) == null){
            return ResponseEntity.badRequest().body(new API("Invalid Customer ID", 401));
        }
        return ResponseEntity.ok(customerSerivce.getCustomer(customer.getCustomerId()));
    }
    @PostMapping("/register/customer")
    public ResponseEntity createCustomer(@RequestBody @Valid Customer customer){
        customerSerivce.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Customer registered",201));
    }


}
