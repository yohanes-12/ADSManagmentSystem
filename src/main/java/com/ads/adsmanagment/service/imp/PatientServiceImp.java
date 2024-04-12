package com.ads.adsmanagment.service.imp;


import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.repository.PatientRepository;
import com.ads.adsmanagment.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImp  implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImp (PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
