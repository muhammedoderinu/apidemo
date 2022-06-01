package com.example.demo.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository
            extends JpaRepository<Address, Long> {
}
