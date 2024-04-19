package com.ads.adsmanagment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String country;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "patient_fk")
    private Patient patient_fk;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "surgery_fk")
    private Surgery surgery_fk;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

}
