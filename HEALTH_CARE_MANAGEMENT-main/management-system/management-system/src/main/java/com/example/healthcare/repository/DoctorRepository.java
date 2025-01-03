package com.example.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
