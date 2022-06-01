package com.example.demo.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }


    @GetMapping(path="/list")
    public List<DoctorInfo> getDoctors(){

        return doctorService.getDoctors();
    }


    @GetMapping(path="/list/{doctorId}")
        public DoctorInfo getDoctor(@PathVariable("doctorId") Long doctorId){
        return doctorService.getDoctor(doctorId);
        }


    @PutMapping(path = "{doctorId}")
    public void updateDoctor(
            @PathVariable("doctorId") Long doctorId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String lga,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String homeAddress){
            doctorService.updateDoctor(doctorId, firstName,
                    lastName, email, phoneNumber,
                    lga, state, homeAddress); {

    }


    }


    @PostMapping(path="/save")
    public void registerNewDoctor(@RequestBody DoctorInfo doctorInfo){

        doctorService.addNewDoctor(doctorInfo);
    }

    @DeleteMapping(path="{doctorId}")
    public void deleteDoctor(
            @PathVariable("doctorId") Long doctorId){
        doctorService.deleteDoctor(doctorId);
    }


}
