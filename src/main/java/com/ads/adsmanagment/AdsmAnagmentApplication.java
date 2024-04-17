package com.ads.adsmanagment;

import com.ads.adsmanagment.dto.request.AddressRequest;
import com.ads.adsmanagment.dto.request.DentistRequest;
import com.ads.adsmanagment.dto.request.PatientRequest;
import com.ads.adsmanagment.model.*;
import com.ads.adsmanagment.service.AppointementService;
import com.ads.adsmanagment.service.DentistService;
import com.ads.adsmanagment.service.PatientService;
import com.ads.adsmanagment.service.SurgeryService;
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
    public void run(String... args) throws Exception {
        System.out.println("Creating new  Dentiest ");
        DentistRequest dentist = new DentistRequest( "Dr. John", "Doe", "43424234242","jhone@gmail.com");
        dentistService.addDentist(dentist);

//        System.out.println("Creating new  Patient ");
//        PatientRequest patientRequest = new PatientRequest(null, "John", "Doe", "43424234242", "jhone@gmail.com", LocalDateTime.now(), new AddressRequest("3th st", "london", "uk" ));
//        patientService.addPatient(patientRequest);
//
//        System.out.println("Creating new  Surgery ");
//        Surgery surgery = new Surgery(null, "pending", LocalDateTime.now(), new Address("3th st", "london", "uk" ), null);
//        surgeryService.addSurgery(surgery);
//
//        System.out.println("Creating new  Appointment ");
//        Appointment appointment = new Appointment(null, LocalDateTime.now(), "london", dentist, patient, surgery);
//        appointementService.addAppointment(appointment);
//
//
//        System.out.println("list of all appointments");
//        appointementService.getAllAppointments().forEach(System.out::println);
//
//        System.out.println("list of all appointments by patient id");
//        appointementService.getAppointmentsByPatientId(1L).forEach(System.out::println);
//
//        System.out.println("list of all appointments by dentist id");
//        appointementService.getAppointmentsByDentistId(1L).forEach(System.out::println);
//
//        System.out.println("list of all appointments by date");
//        appointementService.getAppointmentsByDate(LocalDate.now()).forEach(System.out::println);
//
//        System.out.println("update appointment");
//        appointment.setAppointmentDate(LocalDateTime.now());
//
//        System.out.println("delete appointment by id");
//        appointementService.deleteAppointment(1L);


    }

}
