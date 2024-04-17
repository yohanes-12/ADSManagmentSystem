package com.ads.adsmanagment.dto.request;

import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.AppointmentResponse;

import java.time.LocalDateTime;

public record SurgeryRequest (String description, String type, LocalDateTime surgeryDate, AddressResponse address, AppointmentResponse appointment_fk) {
}
