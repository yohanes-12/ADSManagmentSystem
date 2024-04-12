package com.ads.adsmanagment.repository;

import com.ads.adsmanagment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}
