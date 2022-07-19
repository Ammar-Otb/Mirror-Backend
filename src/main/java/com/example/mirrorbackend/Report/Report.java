package com.example.mirrorbackend.Report;

import com.example.mirrorbackend.Offer.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Report {
    @Id
    private String id = UUID.randomUUID().toString().toUpperCase();

//    @DateTimeFormat
    private Date reportId ;



    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "offerId" ,referencedColumnName = "id")
    private Offer offer;
}
