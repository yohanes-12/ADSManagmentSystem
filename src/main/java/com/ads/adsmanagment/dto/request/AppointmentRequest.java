package com.ads.adsmanagment.dto.request;

import java.time.LocalDateTime;

public record AppointmentRequest(LocalDateTime appointmentDate, String location, Long dentistId, Long patientId, Long surgeryId) {

}
