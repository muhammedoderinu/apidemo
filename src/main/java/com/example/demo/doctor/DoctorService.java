package com.example.demo.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final AddressRepository addressRepository;
    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AddressRepository addressRepository){
        this.doctorRepository = doctorRepository;
        this.addressRepository = addressRepository;

    }

    public List<DoctorInfo> getDoctors(){
       List<Doctor> doctors =  doctorRepository.findAll();
       List<DoctorInfo> doctorsInfo = new ArrayList<>();
       Address address = new Address();
       DoctorInfo doctorInfo = new DoctorInfo();
       for(Doctor doctor: doctors){
           address = doctor.getAddress();
           doctorInfo.setEmail(doctor.getEmail());
           doctorInfo.setFirstName(doctor.getFirstName());
           doctorInfo.setLastName(doctor.getLastName());
           doctorInfo.setPhoneNumber(doctor.getPhoneNumber());
           doctorInfo.setHomeAddress(address.getHomeAddress());
           doctorInfo.setLga(address.getLga());
           doctorInfo.setState(address.getState());
           doctorsInfo.add(doctorInfo);

       }
       return doctorsInfo;

    }

    public void addNewDoctor(DoctorInfo doctorInfo) {
        Doctor doctor = new Doctor();
        Address address = new Address();
        doctor.setFirstName(doctorInfo.getFirstName());
        doctor.setLastName(doctorInfo.getLastName());
        doctor.setEmail(doctorInfo.getEmail());
        doctor.setPhoneNumber(doctorInfo.getPhoneNumber());
        address.setHomeAddress(doctorInfo.getHomeAddress());
        address.setLga(doctorInfo.getLga());
        address.setDoctor(doctor);
      Optional<Doctor> doctorOptional =  doctorRepository.findDoctorByEmail(doctor.getEmail());
      if(doctorOptional.isPresent()){
          throw new IllegalStateException("email taken");

      }

        doctorRepository.save(doctor);
        addressRepository.save(address);
    }

    public void deleteDoctor(Long doctorId) {
        boolean exists = doctorRepository.existsById(doctorId);
        if(!exists){
            throw new IllegalStateException("doctor with id"+doctorId+"does not exists");
        }
        doctorRepository.deleteById(doctorId);
    }
}
