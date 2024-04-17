package com.ads.adsmanagment.dto.request;

import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryRequest {
    private String description;
    private String type;
    private LocalDateTime surgeryDate;
    private AddressRequest address;
    private AppointmentRequest appointment_fk;
}
