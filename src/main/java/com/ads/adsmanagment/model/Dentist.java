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
    private Long dentistId;
    private String firstName;
    private String lastName;
    private String dentistPhone;
    private String email;

    @OneToMany(mappedBy = "dentist_fk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointment;

    public Dentist(Long dentistId,String firstName, String lastName, String dentistPhone, String email) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dentistPhone = dentistPhone;
        this.email = email;
    }


}
