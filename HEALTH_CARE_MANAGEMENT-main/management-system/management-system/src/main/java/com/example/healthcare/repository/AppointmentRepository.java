package com.example.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
