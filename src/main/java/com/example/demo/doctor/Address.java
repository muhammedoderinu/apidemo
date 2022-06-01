package com.example.demo.doctor;

import javax.persistence.*;

@Entity(name="Address")
@Table(name="address")

public class Address {
    @Column(name="age")
    @Id
    //@SequenceGenerator(name="doctor_sequence",
            //sequenceName = "doctor_sequence",
            //allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long Id;
    @Column(
            name="home_Address",
            nullable=false,
            columnDefinition = "TEXT"
    )
    String homeAddress;
    @Column(
            name="lga",
            nullable=false,
            columnDefinition = "TEXT"
    )
    String lga;
    @Column(
            name="state",
            nullable=false,
            columnDefinition = "TEXT"
    )
    String state;
    @OneToOne
    @JoinColumn(name="doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public Address(Long Id,
                   String homeAddress,
                   String lga,
                   String state){
        this.Id = Id;
        this.homeAddress = homeAddress;
        this.lga = lga;
        this.state = state;

    }

    public Address() {

    }

    public Long getId(){
        return Id;
    }
    public void setId(Long Id){
        this.Id = Id;
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


    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

}
