package com.ads.adsmanagment.service;

import com.ads.adsmanagment.dto.request.DentistRequest;
import com.ads.adsmanagment.dto.response.DentistResponse;
import com.ads.adsmanagment.model.Dentist;

public interface DentistService {

    public DentistResponse addDentist(DentistRequest dentistRequest);
}
