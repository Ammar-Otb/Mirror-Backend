package com.example.mirrorbackend.Beautician;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.File;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class Beautician  implements UserDetails {
    @Id
    private String id = UUID.randomUUID().toString().toUpperCase();

    @NotNull( message = "Username Is Required")
    @Length(min = 3 , max = 15 , message = "The username must be between ( 3 - 15 ) Characters")
    @Column(unique = true , nullable = false)
    private String username ;

    @NotNull(message = "Password Is Required ")
//    @Length(min = 7 , max = 20 , message = "The username must be between ( 7 - 20 ) Characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;

    @NotNull(message = "Phone Number Is Required")
    @Pattern(regexp = "05[^12A-Za-z!@#$%^&*_-]\\d{7}")
    private String phone;

    private String role = "BEAUTICIAN";

    @NotNull
//    get back
    private String qualification ;

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
