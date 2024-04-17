package com.ads.adsmanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surgerys")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;

    private String description;
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime surgeryDate;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "appoint_id")
    private List<Appointment> appointment_fk;

}
