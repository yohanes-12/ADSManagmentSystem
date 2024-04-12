package com.ads.adsmanagment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentist_id;
    private String firstName;
    private String lastName;
    private String dentistPhone;
    private String email;

    @OneToMany(mappedBy = "appointment_fk")
    private List<Appointment> appointment;


}
