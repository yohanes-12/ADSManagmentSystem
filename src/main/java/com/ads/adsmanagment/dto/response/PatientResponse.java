package com.ads.adsmanagment.dto.response;
import java.time.LocalDateTime;
import java.util.List;

public record PatientResponse (Long id, String firstName, String lastName, String phone, String email, LocalDateTime dob, AddressResponse address, List<AppointmentResponse> appointmentList) {}
