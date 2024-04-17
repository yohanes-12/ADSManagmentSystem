package com.ads.adsmanagment.dto.request;

import com.ads.adsmanagment.model.Address;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dob;
    private AddressRequest address;

}
