package com.example.mirrorbackend.Customer;

import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer") @AllArgsConstructor @NoArgsConstructor @Data
public class Customer implements UserDetails {
    @Id
    private String customerId = UUID.randomUUID().toString().toUpperCase();


    private String role = "CUSTOMER";
    @NotNull @Size(min = 2, max = 15, message = "Name length must be between 2 and 25") @Column(unique = true)
    private String username;
     @Email @Column(unique = true) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @NotNull(message = "Password length must not be empty") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotNull @Column(unique = true) @Pattern(regexp = "05[^12A-Za-z!@#$%^&*_-]\\d{7}", message = "Phone number must be 10 digits long and starts with 05 followed by any number except 2 or 1")
    private String phone;

    @OneToMany( fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    @JsonIgnore
    private Set<ServiceRequest> serviceRequests;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}