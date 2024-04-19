package com.ads.adsmanagment.dto.request;

import java.time.LocalDateTime;

public record SurgeryRequest (String description, String type, LocalDateTime surgeryDate, AddressRequest address, AppointmentRequest appointment_fk) {

}
