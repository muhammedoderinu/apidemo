package com.example.demo.doctor;

import javax.persistence.*;

public class DoctorInfo {


        String firstName;
        String lastName;
        String email;
        String phoneNumber;
        String homeAddress;
        String lga;
        String state;


        public DoctorInfo(String firstName,
                          String lastName,
                          String email,
                          String phoneNumber,
                          String homeAddress,
                          String lga,
                          String state
                      ){
                            this.firstName = firstName;
                            this.lastName = lastName;
                            this.email = email;
                            this.phoneNumber = phoneNumber;
                            this.homeAddress = homeAddress;
                            this.lga = lga;
                            this.state = state;


        }

        public DoctorInfo() {

        }

        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }

        public String getEmail(){
            return email;
        }

        public String getPhoneNumber(){
            return phoneNumber;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        public void setLastName(String lastName){
            this.lastName = lastName;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
        }


        public String getHomeAddress(){
            return homeAddress;
        }
        public void setHomeAddress(String homeAddress){
            this.homeAddress = homeAddress;
        }


        public String getLga(){
            return lga;
        }
        public void setLga(String lga){
            this.lga = lga;
        }

        public String getState(){
            return state;
        }

        public void setState(String state){
            this.state = state;
        }




}


