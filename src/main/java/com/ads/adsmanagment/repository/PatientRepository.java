package com.ads.adsmanagment.repository;

import com.ads.adsmanagment.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

public interface PatientRepository extends ListCrudRepository<Patient, Long> {
}
