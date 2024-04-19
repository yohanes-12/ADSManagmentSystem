package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.model.Appointment;
import com.ads.adsmanagment.model.Dentist;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.model.Surgery;
import com.ads.adsmanagment.repository.AppointmentRepository;
import com.ads.adsmanagment.repository.DentistRepository;
import com.ads.adsmanagment.repository.PatientRepository;
import com.ads.adsmanagment.repository.SurgeryRepository;
import com.ads.adsmanagment.service.AppointementService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServeiceImp implements AppointementService {

    private AppointmentRepository appointmentRepository;
    private DentistRepository dentistRepository;

    private SurgeryRepository surgeryRepository;

    private PatientRepository patientRepository;

    public AppointmentServeiceImp(AppointmentRepository appointmentRepository, DentistRepository dentistRepository, SurgeryRepository surgeryRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.dentistRepository = dentistRepository;
        this.surgeryRepository = surgeryRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public AppointmentResponse addAppointment(AppointmentRequest appointment) {
        if(dentistRepository.findById(appointment.dentistId()).isEmpty() || patientRepository.findById(appointment.patientId()).isEmpty() || surgeryRepository.findById(appointment.surgeryId()).isEmpty()){
            return null;
        }

        System.out.printf("dentistId: %d, patientId: %d, surgeryId: %d\n", appointment.dentistId(), appointment.patientId(), appointment.surgeryId());
        Optional<Dentist> dentistOptional = dentistRepository.findById(appointment.dentistId());
        Optional<Patient> patientOptional = patientRepository.findById(appointment.patientId());
        Optional<Surgery> surgeryOptional = surgeryRepository.findById(appointment.surgeryId());

        if (dentistOptional.isPresent() && patientOptional.isPresent() && surgeryOptional.isPresent()){

            Appointment newAppointment = new Appointment(null, appointment.appointmentDate(), appointment.location(), dentistOptional.get(), patientOptional.get(), surgeryOptional.get());
            appointmentRepository.save(newAppointment);
            return new AppointmentResponse(newAppointment.getAppoint_id(), newAppointment.getAppointmentDate(), newAppointment.getLocation(), newAppointment.getDentist_fk().getFirstName() + newAppointment.getDentist_fk().getLastName(), newAppointment.getPatient_fk().getFirstName() + newAppointment.getPatient_fk().getLastName(), newAppointment.getSurgery_fk().getDescription());
        }
        return null;
    }
}
