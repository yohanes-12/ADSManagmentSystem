package com.ads.adsmanagment.dto.request;

import com.ads.adsmanagment.model.Dentist;
import com.ads.adsmanagment.model.Patient;
import com.ads.adsmanagment.model.Surgery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
        private Long id;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
        private LocalDateTime appointmentDate;
        private String location;
        private Long dentistId;
        private Long patientId;
        private Long surgeryId;
}
