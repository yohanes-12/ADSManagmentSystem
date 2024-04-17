package com.ads.adsmanagment.dto.response;

import com.ads.adsmanagment.dto.request.AddressRequest;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDateTime dob;
    private AddressResponse address;
    private List<AppointmentResponse> appointmentList;

}
