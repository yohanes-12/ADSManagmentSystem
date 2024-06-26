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

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientResponse addPatient(PatientRequest patientRequest) {
        Patient savedPatient = new Patient(
                null,
                patientRequest.firstName(),
                patientRequest.lastName(),
                patientRequest.email(),
                patientRequest.phone(),
                patientRequest.dob(),
                new Address( patientRequest.address().street(),
                        patientRequest.address().city(),
                        patientRequest.address().country()),
                null);
        patientRepository.save(savedPatient);

        return new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getEmail(),
                savedPatient.getPhone(),
                savedPatient.getDob(),
                new AddressResponse(
                        savedPatient.getPatientId(),
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getCountry()
                ),
                Optional.ofNullable(savedPatient.getAppointmentList())
                        .orElse(List.of())
                        .stream()
                        .map(a -> new AppointmentResponse(
                                a.getAppoint_id(),
                                a.getAppointmentDate(),
                                a.getLocation(),
                                a.getDentist_fk().getFirstName() + a.getDentist_fk().getLastName(),
                                a.getPatient_fk().getFirstName() + a.getPatient_fk().getLastName(),
                                a.getSurgery_fk().getDescription()
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
                        p.getAddress().getAddressId(),
                        p.getAddress().getStreet(),
                        p.getAddress().getCity(),
                        p.getAddress().getCountry()
                ),  Optional.ofNullable(p.getAppointmentList())
                        .orElse(List.of())
                        .stream()
                        .map(a -> new AppointmentResponse(
                                a.getAppoint_id(),
                                a.getAppointmentDate(),
                                a.getLocation(),
                                Optional.ofNullable(a.getDentist_fk()).map(d -> d.getFirstName()+d.getLastName()).orElse(null),
                                Optional.ofNullable(a.getPatient_fk()).map(p1 -> p1.getFirstName() + p1.getLastName()).orElse(null),
                                Optional.ofNullable(a.getSurgery_fk()).map(s -> s.getDescription()).orElse(null)
                        )).toList()
        )).collect(Collectors.toList());
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
                        p.getAddress().getAddressId(),
                        p.getAddress().getStreet(),
                        p.getAddress().getCity(),
                        p.getAddress().getCountry()
                ), Optional.ofNullable(p.getAppointmentList()).orElse(List.of()).stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        Optional.ofNullable(a.getDentist_fk()).map(d -> d.getFirstName()+d.getLastName()).orElse(null),
                Optional.ofNullable(a.getPatient_fk()).map(p1 -> p1.getFirstName() + p1.getLastName()).orElse(null),
                Optional.ofNullable(a.getSurgery_fk()).map(s -> s.getDescription()).orElse(null) )).toList()
        )).orElse(null);
    }

    @Override
    public PatientResponse updatePatient(Long pId, PatientRequest patientrequest) {
        Optional<Patient> patient = patientRepository.findById(pId);

        if(patient == null){
            return null;
        }

        patient.get().setFirstName(patientrequest.firstName());
        patient.get().setLastName(patientrequest.lastName());
        patient.get().setEmail(patientrequest.email());
        patient.get().setPhone(patientrequest.phone());
        patient.get().setDob(patientrequest.dob());
        patient.get().getAddress().setStreet(patientrequest.address().street());
        patient.get().getAddress().setCity(patientrequest.address().city());
        patient.get().getAddress().setCountry(patientrequest.address().country());
        patientRepository.save(patient.get());

        return new PatientResponse(
                patient.get().getPatientId(),
                patient.get().getFirstName(),
                patient.get().getLastName(),
                patient.get().getEmail(),
                patient.get().getPhone(),
                patient.get().getDob(),
                new AddressResponse(
                        patient.get().getAddress().getAddressId(),
                        patient.get().getAddress().getStreet(),
                        patient.get().getAddress().getCity(),
                        patient.get().getAddress().getCountry()
                ),
                patient.get().getAppointmentList().stream().map(a -> new AppointmentResponse(
                        a.getAppoint_id(),
                        a.getAppointmentDate(),
                        a.getLocation(),
                        a.getDentist_fk().getFirstName() + a.getDentist_fk().getLastName(),
                        a.getPatient_fk().getFirstName() + a.getPatient_fk().getLastName(),
                        a.getSurgery_fk().getDescription())
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
                p.getAddress().getAddressId(),
                p.getAddress().getStreet(),
                p.getAddress().getCity(),
                p.getAddress().getCountry()
        )).collect(Collectors.toList());
    }
}
