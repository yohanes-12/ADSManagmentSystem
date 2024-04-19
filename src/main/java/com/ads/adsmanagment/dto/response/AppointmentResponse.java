package com.ads.adsmanagment.dto.response;

import java.time.LocalDateTime;

public record AppointmentResponse (Long id, LocalDateTime appointmentDate, String location, String dentistName, String patientName, String surgeryDescription) {
 }
