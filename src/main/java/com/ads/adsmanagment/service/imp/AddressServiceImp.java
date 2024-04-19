package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp {
    private AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressResponse> getAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> new AddressResponse(
                        a.getAddressId(),
                        a.getStreet(), a.getCity(), a.getCountry()
                )).collect(Collectors.toList());
    }
}
