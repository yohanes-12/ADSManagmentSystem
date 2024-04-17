package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.model.Appointment;
import com.ads.adsmanagment.repository.AppointmentRepository;
import com.ads.adsmanagment.service.AppointementService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServeiceImp implements AppointementService {

    private AppointmentRepository appointmentRepository;

    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }

    @Override
    public AppointmentResponse addAppointment(AppointmentRequest appointment) {
        Appointment newAppointment = new Appointment(null, appointment.getAppointmentDate(),appointment.getLocation(),  null, null, null);
        appointmentRepository.save(newAppointment);
        return new AppointmentResponse(newAppointment.getAppoint_id(), newAppointment.getAppointmentDate(), newAppointment.getLocation(), newAppointment.getDentist_fk().getDentist_id(), newAppointment.getPatient_fk().getPatientId(), newAppointment.getSurgery_fk().getRecordId());
    }

}
