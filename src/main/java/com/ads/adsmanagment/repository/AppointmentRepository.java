package com.ads.adsmanagment.repository;

import com.ads.adsmanagment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
