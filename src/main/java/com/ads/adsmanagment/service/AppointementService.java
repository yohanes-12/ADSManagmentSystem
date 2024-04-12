package com.ads.adsmanagment.service;

import com.ads.adsmanagment.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointementService {

    public Appointment addAppointment(Appointment appointment);

    public List<Appointment> getAllAppointments();


    public Appointment getAppointmentById(Long id);

    public void deleteAppointment(Long id);

    public Appointment updateAppointment(Appointment appointment);

    public List<Appointment> getAppointmentsByPatientId(Long id);

    public List<Appointment> getAppointmentsByDentistId(Long id);

    public List<Appointment> getAppointmentsByDate(LocalDate date);

}
