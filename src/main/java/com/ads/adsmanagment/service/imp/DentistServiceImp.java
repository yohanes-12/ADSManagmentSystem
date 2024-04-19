package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.DentistRequest;
import com.ads.adsmanagment.dto.response.DentistResponse;
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
    public DentistResponse addDentist(DentistRequest dentist) {
        Dentist newDentist = new Dentist(null, dentist.firstName(), dentist.lastName(), dentist.email(), dentist.dentistPhone(), null);

        dentistRepository.save(newDentist);
        return new DentistResponse(newDentist.getDentistId(), newDentist.getFirstName(), newDentist.getLastName(), newDentist.getEmail(), newDentist.getDentistPhone(), null);
    }

}
