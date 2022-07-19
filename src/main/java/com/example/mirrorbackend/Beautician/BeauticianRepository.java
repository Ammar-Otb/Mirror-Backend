package com.example.mirrorbackend.Beautician;

import com.example.mirrorbackend.ServiceRequest.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeauticianRepository extends JpaRepository<Beautician , String> {
    Beautician findByUsername(String username);
}
