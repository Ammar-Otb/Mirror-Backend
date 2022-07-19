package com.example.mirrorbackend.UserDetails;
import com.example.mirrorbackend.Beautician.Beautician;
import com.example.mirrorbackend.Customer.Customer;
import com.example.mirrorbackend.Customer.CustomerSerivce;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final CustomerSerivce customerSerivce;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer= ((customerSerivce.findMyUserByUsername(username)));
        if(customer == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return customer;
    }

}