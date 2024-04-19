package com.ads.adsmanagment.controller;

import com.ads.adsmanagment.dto.request.PatientRequest;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PatientResponse>> getAllPatientList() {
       return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping(value = "/get/{patientId}")
    public ResponseEntity<PatientResponse> getPatientById(@Valid Long patientId){
        return ResponseEntity.ok(patientService.getPatientById(patientId));
}


    @PostMapping(value = "/register")
    public ResponseEntity<PatientResponse> registerNewPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return new ResponseEntity<>(patientService.addPatient(patientRequest), HttpStatus.CREATED);
    }

    @PostMapping(value = "/update/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(@Valid  Long patientId, @Valid @RequestBody PatientRequest patientrequest) {
        return ResponseEntity.ok(patientService.updatePatient(patientId, patientrequest));
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public void deletePatient(@Valid Long patientId) {
        patientService.deletePatient(patientId);
    }

}
