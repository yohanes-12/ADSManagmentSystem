package com.ads.adsmanagment.controller;

import com.ads.adsmanagment.service.AppointementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adsweb/api/v1/appointment")
public class AppointmentController {

    private AppointementService appointmentService;

    public AppointmentController(AppointementService appointmentService) {
        this.appointmentService = appointmentService;
    }


}
