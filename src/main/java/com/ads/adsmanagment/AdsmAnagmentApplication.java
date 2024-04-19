package com.ads.adsmanagment;

import com.ads.adsmanagment.dto.request.*;
import com.ads.adsmanagment.dto.response.AddressResponse;
import com.ads.adsmanagment.model.*;
import com.ads.adsmanagment.service.AppointementService;
import com.ads.adsmanagment.service.DentistService;
import com.ads.adsmanagment.service.PatientService;
import com.ads.adsmanagment.service.SurgeryService;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class AdsmAnagmentApplication implements CommandLineRunner {

    private final AppointementService appointementService;
    private final SurgeryService surgeryService;

    private final PatientService patientService;
    private  final DentistService   dentistService;

    public AdsmAnagmentApplication(AppointementService appointementService, SurgeryService surgeryService, PatientService patientService, DentistService dentistService) {
        this.appointementService = appointementService;
        this.surgeryService = surgeryService;
        this.patientService = patientService;
        this.dentistService = dentistService;
    }


    public static void main(String[] args) {
        SpringApplication.run(AdsmAnagmentApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Creating new  Dentiest ");
        DentistRequest dentist = new DentistRequest( "Dr. John", "Doe", "43424234242","jhone@gmail.com");
        dentistService.addDentist(dentist);


        System.out.println("Creating new  Patient ");
        PatientRequest patientRequest = new PatientRequest("John", "Doe", "43424234242", "jhone@gmail.com", LocalDateTime.now(), new AddressRequest("3th st", "london", "uk" ));
        patientService.addPatient(patientRequest);


        System.out.println("Creating new  Surgery ");
        SurgeryRequest surgeryRequest = new SurgeryRequest("surgery 1", "kidny",LocalDateTime.of(2024,05,05,05,20), new AddressRequest("3th st", "london", "uk"), null);
        surgeryService.addSurgery(surgeryRequest);

        System.out.println("Creating new  Appointment ");
        AppointmentRequest appointmentRequest = new AppointmentRequest(LocalDateTime.now(), "london",  1L, 1L, 1L);
        appointementService.addAppointment(appointmentRequest);


        System.out.println("Hello RESTful Web API");
        System.out.println("ADS Managment WebAPI server. Starting...");
        System.out.println("ADS WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
        System.out.println("To see list of Patient, send HTTP GET Request to the URI,\nhttp://localhost:8080/adsweb/api/v1/patient/list");



    }

}
