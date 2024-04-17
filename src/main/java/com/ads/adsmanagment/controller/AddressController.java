package com.ads.adsmanagment.controller;


import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Address;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    private PatientService patientService;

    public AddressController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public List<AddressResponse> getAllPatientList() {
        return patientService.getPatientAddress();

    }
}