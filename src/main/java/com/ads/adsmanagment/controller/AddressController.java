package com.ads.adsmanagment.controller;


import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Address;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.service.PatientService;
import com.ads.adsmanagment.service.imp.AddressServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    private AddressServiceImp addressServiceImp;

    public AddressController(AddressServiceImp addressServiceImp) {
        this.addressServiceImp = addressServiceImp;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<AddressResponse>> getAllPatientList() {
        return ResponseEntity.ok(addressServiceImp.getAddresses());
    }
}
