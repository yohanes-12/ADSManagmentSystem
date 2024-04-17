package com.ads.adsmanagment.controller;

import com.ads.adsmanagment.dto.request.PatientRequest;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public List<PatientResponse> getAllPatientList() {
       return patientService.getAllPatients();
    }

    @GetMapping(value = "/get/{patientId}")
    public PatientResponse getPatientById(Long patientId){
        return patientService.getPatientById(patientId);
}


    @PostMapping(value = "/register")
    public PatientResponse registerNewPatient(PatientRequest patientRequest) {
        return patientService.addPatient(patientRequest);
    }

    @PostMapping(value = "/update/{patientId}")
    public PatientResponse updatePatient(Long patientId, PatientRequest patientrequest) {
        return patientService.updatePatient(patientId, patientrequest);
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public void deletePatient(Long patientId) {
        patientService.deletePatient(patientId);
    }

}
