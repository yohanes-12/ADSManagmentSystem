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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dob;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "appointment_fk")
    private List<Appointment> appointmentList;


}
