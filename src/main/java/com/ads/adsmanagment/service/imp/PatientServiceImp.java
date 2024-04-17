package com.ads.adsmanagment.service.imp;


import com.ads.adsmanagment.dto.request.PatientRequest;
import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.dto.response.PatientResponse;
import com.ads.adsmanagment.model.Address;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.repository.PatientRepository;
import com.ads.adsmanagment.service.PatientService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp  implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImp (PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientResponse addPatient(PatientRequest patientRequest) {
        Patient savedPatient = new Patient(
                null,
                patientRequest.getFirstName(),
                patientRequest.getLastName(),
                patientRequest.getEmail(),
                patientRequest.getPhone(),
                patientRequest.getDob(),
                new Address(patientRequest.getAddress().getStreet(),
                        patientRequest.getAddress().getCity(),
                        patientRequest.getAddress().getCountry()),null
        );
        patientRepository.save(savedPatient);

        return new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getEmail(),
                savedPatient.getPhone(),
                savedPatient.getDob(),
                new AddressResponse(
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getCountry()
                ),
                savedPatient.getAppointmentList().stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        a.getDentist_fk().getDentist_id(),
                        a.getPatient_fk().getPatientId(),
                        a.getSurgery_fk().getRecordId()
                )).toList()
        );
    }
    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream().map(p -> new PatientResponse(
                p.getPatientId(),
                p.getFirstName(),
                p.getLastName(),
                p.getPhone(),
                p.getEmail(),
                p.getDob(),
                new AddressResponse(
                        p.getAddress().getStreet(),
                        p.getAddress().getCity(),
                        p.getAddress().getCountry()
                ),
                p.getAppointmentList().stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        a.getDentist_fk().getDentist_id(),
                        a.getPatient_fk().getPatientId(),
                        a.getSurgery_fk().getRecordId())
                ).toList())).collect(Collectors.toList());
    }
    @Override
    public PatientResponse getPatientById(Long id) {

        return patientRepository.findById(id).map(p -> new PatientResponse(
                p.getPatientId(),
                p.getFirstName(),
                p.getLastName(),
                p.getPhone(),
                p.getEmail(),
                p.getDob(),
                new AddressResponse(
                        p.getAddress().getStreet(),
                        p.getAddress().getCity(),
                        p.getAddress().getCountry()
                ),
                p.getAppointmentList().stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        a.getDentist_fk().getDentist_id(),
                        a.getPatient_fk().getPatientId(),
                        a.getSurgery_fk().getRecordId())
                ).toList())).orElse(null);
    }

    @Override
    public PatientResponse updatePatient(Long pId, PatientRequest patientrequest) {
        Optional<Patient> patient = patientRepository.findById(pId);

        if(patient == null){
            return null;
        }

        patient.get().setFirstName(patientrequest.getFirstName());
        patient.get().setLastName(patientrequest.getLastName());
        patient.get().setEmail(patientrequest.getEmail());
        patient.get().setPhone(patientrequest.getPhone());
        patient.get().setDob(patientrequest.getDob());
        patient.get().setAddress(new Address(patientrequest.getAddress().getStreet(),
                patientrequest.getAddress().getCity(),
                patientrequest.getAddress().getCountry()));
        patientRepository.save(patient.get());

        return new PatientResponse(
                patient.get().getPatientId(),
                patient.get().getFirstName(),
                patient.get().getLastName(),
                patient.get().getEmail(),
                patient.get().getPhone(),
                patient.get().getDob(),
                new AddressResponse(
                        patient.get().getAddress().getStreet(),
                        patient.get().getAddress().getCity(),
                        patient.get().getAddress().getCountry()
                ),
                patient.get().getAppointmentList().stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        a.getDentist_fk().getDentist_id(),
                        a.getPatient_fk().getPatientId(),
                        a.getSurgery_fk().getRecordId())
                ).toList()
        );
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<AddressResponse> getPatientAddress() {
        return patientRepository.findAll().stream().map(p -> new AddressResponse(
                p.getAddress().getStreet(),
                p.getAddress().getCity(),
                p.getAddress().getCountry()
        )).collect(Collectors.toList());
    }

}
