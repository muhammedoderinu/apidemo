package com.example.demo.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository
        extends JpaRepository<Doctor,Long > {
    Optional<Doctor> findDoctorByEmail(String email);
}

