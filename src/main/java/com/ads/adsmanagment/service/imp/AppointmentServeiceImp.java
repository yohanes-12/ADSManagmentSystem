package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.model.Appointment;
import com.ads.adsmanagment.model.Dentist;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.model.Surgery;
import com.ads.adsmanagment.repository.AppointmentRepository;
import com.ads.adsmanagment.service.AppointementService;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServeiceImp implements AppointementService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServeiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);

    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {

        Appointment updatedAppointment = appointmentRepository.findById(appointment.getAppoint_id()).orElse(null);
        if(updatedAppointment == null || updatedAppointment.getAppoint_id() != appointment.getAppoint_id()){
             return appointmentRepository.save(updatedAppointment);

        }

        updatedAppointment = new Appointment(appointment.getAppoint_id(), appointment.getAppointmentDate(), appointment.getLocation(), appointment.getDentist_fk(), appointment.getPatient_fk(), appointment.getSurgery_fk());


        return appointmentRepository.save(updatedAppointment);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long id) {
        return  appointmentRepository.findAllByPatient_fk(id);
    }

    @Override
    public List<Appointment> getAppointmentsByDentistId(Long id) {
        return appointmentRepository.findAllByDentist_fk(id);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findAllByAppointmentDate(date);
    }
}
