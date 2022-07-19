package com.example.mirrorbackend.Beautician;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeauticianService implements UserDetailsService {

    private final BeauticianRepository beauticianRepository ;

    public List<Beautician> getBeauticians() {
        return beauticianRepository.findAll();
    }

//    register
    public void addBeauticians(Beautician beautician) {
        beauticianRepository.save(beautician);

    }

    public Beautician getBeautician(String btId) {
        return beauticianRepository.findById(btId).get(); // possible throw some error handling here
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Beautician beautician = getBeauticianByUsername(username);
        if(beautician == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return beautician;
    }

    private Beautician getBeauticianByUsername(String username) {
        return beauticianRepository.findByUsername(username);
    }
}
