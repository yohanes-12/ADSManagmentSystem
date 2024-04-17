package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.model.Appointment;
import com.ads.adsmanagment.model.Dentist;
import com.ads.adsmanagment.repository.AppointmentRepository;
import com.ads.adsmanagment.repository.DentistRepository;
import com.ads.adsmanagment.repository.PatientRepository;
import com.ads.adsmanagment.repository.SurgeryRepository;
import com.ads.adsmanagment.service.AppointementService;
import org.springframework.stereotype.Service;

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
    public AppointmentResponse addAppointment(AppointmentRequest appointment) {
        Appointment newAppointment = new Appointment(null, appointment.getAppointmentDate(),appointment.getLocation(),
                dentistRepository.findById(appointment.getDentistId()).orElse(null),
                patientRepository.findById(appointment.getPatientId()).orElse(null),
                surgeryRepository.findById(appointment.getSurgeryId()).orElse(null));
        appointmentRepository.save(newAppointment);
        return new AppointmentResponse(newAppointment.getAppoint_id(), newAppointment.getAppointmentDate(), newAppointment.getLocation(), newAppointment.getDentist_fk().getDentistId(), newAppointment.getPatient_fk().getPatientId(), newAppointment.getSurgery_fk().getSurgeryId());
    }

}
