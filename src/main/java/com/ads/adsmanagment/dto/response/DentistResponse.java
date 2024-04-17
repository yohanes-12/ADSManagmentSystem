package com.ads.adsmanagment.dto.response;

public record DentistResponse ( Long dentist_id, String firstName, String lastName, String dentistPhone, String email, String appointment_fk) {}