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
