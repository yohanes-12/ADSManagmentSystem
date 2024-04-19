package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.AddressRequest;
import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.request.SurgeryRequest;
import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.dto.response.DentistResponse;
import com.ads.adsmanagment.dto.response.SurgeryResponse;
import com.ads.adsmanagment.model.*;
import com.ads.adsmanagment.repository.SurgeryRepository;
import com.ads.adsmanagment.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImp implements SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImp(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public SurgeryResponse addSurgery(SurgeryRequest surgery) {
        Surgery newSurgery = new Surgery(null, surgery.description(), surgery.type(), surgery.surgeryDate(), new Address(surgery.address().street(), surgery.address().city(), surgery.address().country()), null);
        surgeryRepository.save(newSurgery);
        return new SurgeryResponse(newSurgery.getSurgeryId(), newSurgery.getDescription(), newSurgery.getType(), newSurgery.getSurgeryDate(), new AddressResponse(newSurgery.getSurgeryId(), newSurgery.getAddress().getStreet(), newSurgery.getAddress().getCity(), newSurgery.getAddress().getCountry()), null
        );
    }

}
