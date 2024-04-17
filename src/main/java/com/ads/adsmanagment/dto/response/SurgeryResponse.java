package com.ads.adsmanagment.dto.response;

import java.time.LocalDateTime;

public record SurgeryResponse (
        Long id, String description, String type, LocalDateTime surgeryDate, AddressResponse address, AppointmentResponse appointment_fk) {
}
