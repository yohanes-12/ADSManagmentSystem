package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.SurgeryRequest;
import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.SurgeryResponse;
import com.ads.adsmanagment.model.Address;
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
    public SurgeryResponse addSurgery(SurgeryRequest surgery) {
        Surgery newSurgery = new Surgery(null, surgery.description(), surgery.type(), surgery.surgeryDate(), new Address(surgery.address().getStreet(),surgery.address().getCity(),surgery.address().getCountry()), null);
        surgeryRepository.save(newSurgery);
        return new SurgeryResponse(newSurgery.getRecordId(), newSurgery.getDescription(), newSurgery.getType(), newSurgery.getSurgeryDate(), new AddressResponse(newSurgery.getAddress().getStreet(), newSurgery.getAddress().getCity(), newSurgery.getAddress().getCountry()), null);
    }
}
