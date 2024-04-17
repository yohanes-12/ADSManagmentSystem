package com.ads.adsmanagment.service;

import com.ads.adsmanagment.dto.request.PatientRequest;
import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Address;
import com.ads.adsmanagment.model.Patient;

import java.util.List;

public interface PatientService {


    public PatientResponse addPatient(PatientRequest patientRequest);

    public List<PatientResponse> getAllPatients();
    public PatientResponse getPatientById(Long id);

    public PatientResponse updatePatient(Long pId, PatientRequest patientRequest);

    public void deletePatient(Long id);

    List<AddressResponse> getPatientAddress();

}
