package com.ads.adsmanagment.service;

import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.model.Appointment;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointementService {

    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest);


}
