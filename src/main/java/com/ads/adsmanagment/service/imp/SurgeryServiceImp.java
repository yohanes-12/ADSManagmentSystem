package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.model.Surgery;
import com.ads.adsmanagment.repository.SurgeryRepository;
import com.ads.adsmanagment.service.SurgeryService;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImp implements SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImp(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    @Override
    public Surgery addSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
