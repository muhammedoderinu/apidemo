package com.example.demo.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public DoctorInfo getDoctor(Long doctorId) {
        Address address = new Address();
        DoctorInfo doctorInfo = new DoctorInfo();

        Optional<Doctor> doctor =  doctorRepository.findById(doctorId);
        address = doctor.get().getAddress();
        doctorInfo.setEmail(doctor.get().getEmail());
        doctorInfo.setFirstName(doctor.get().getFirstName());
        doctorInfo.setLastName(doctor.get().getLastName());
        doctorInfo.setPhoneNumber(doctor.get().getPhoneNumber());
        doctorInfo.setHomeAddress(address.getHomeAddress());
        doctorInfo.setLga(address.getLga());
        doctorInfo.setState(address.getState());

        return doctorInfo;


    }

    @Transactional
    public void updateDoctor(Long doctorId, String firstName,
                             String lastName, String email, String phoneNumber,
                             String lga, String state, String homeAddress) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                ()-> new IllegalStateException(
                        "doctor with id" +doctorId+ "does not exist"));

        Address address = doctor.getAddress();

        if(firstName!=null && firstName.length()>0 && !Objects.equals(doctor.getFirstName(),
              firstName)){
            doctor.setFirstName(firstName);
        }

        if(lastName!=null && lastName.length()>0 && !Objects.equals(doctor.getLastName(),
                lastName)){
            doctor.setLastName(lastName);
        }
        if(phoneNumber!=null && phoneNumber.length()>0 && !Objects.equals(doctor.getPhoneNumber(),
                phoneNumber)){
            doctor.setPhoneNumber(phoneNumber);
        }

        if(email!=null && email.length()>0 && !Objects.equals(doctor.getEmail(),
                email)){
            doctor.setEmail(email);
        }

        if(lga!=null && lga.length()>0 && !Objects.equals(address.getLga(),
                lga)){
            address.setLga(lga);
        }

        if(state!=null && state.length()>0 && !Objects.equals(address.getState(),
                state)){
            address.setState(state);
        }

        if(homeAddress!=null && homeAddress.length()>0 && !Objects.equals(address.getHomeAddress(),
                homeAddress)){
            address.setHomeAddress(homeAddress);
        }





    }
}
