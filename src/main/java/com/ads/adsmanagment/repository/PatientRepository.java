package com.ads.adsmanagment.repository;

import com.ads.adsmanagment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}
