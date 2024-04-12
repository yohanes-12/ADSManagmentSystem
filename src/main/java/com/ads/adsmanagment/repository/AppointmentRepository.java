package com.ads.adsmanagment.repository;

import com.ads.adsmanagment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPatient_fk(Long id);

    List<Appointment> findAllByDentist_fk(Long id);

    List<Appointment> findAllByAppointmentDate(LocalDate date);
}
