package com.ads.adsmanagment.dto.request;

import java.time.LocalDateTime;

public record PatientRequest (String firstName, String lastName, String phone, String email, LocalDateTime dob, AddressRequest address) {


}
