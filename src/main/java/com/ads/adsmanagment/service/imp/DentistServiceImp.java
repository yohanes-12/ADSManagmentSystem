package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.model.Dentist;
import com.ads.adsmanagment.repository.DentistRepository;
import com.ads.adsmanagment.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImp implements DentistService {
    private DentistRepository dentistRepository;

    public DentistServiceImp(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist addDentist(Dentist dentist) {
       return dentistRepository.save(dentist);
    }
}
