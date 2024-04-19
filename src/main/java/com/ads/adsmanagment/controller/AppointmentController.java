package com.ads.adsmanagment.controller;

import com.ads.adsmanagment.dto.request.AppointmentRequest;
import com.ads.adsmanagment.dto.response.AppointmentResponse;
import com.ads.adsmanagment.service.AppointementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adsweb/api/v1/appointment")
public class AppointmentController {

    private AppointementService appointmentService;

    public AppointmentController(AppointementService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<AppointmentResponse> addAppointment(AppointmentRequest appointmentRequest) {
        AppointmentResponse appointmentResponse = appointmentService.addAppointment(appointmentRequest);
        return ResponseEntity.ok(appointmentResponse);
    }



}
