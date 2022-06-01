package com.example.demo.doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DoctorConfig {

    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository, AddressRepository addressRepository){
        return args -> {



        };
    }

}
