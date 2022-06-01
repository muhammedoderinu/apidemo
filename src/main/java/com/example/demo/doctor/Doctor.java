package com.example.demo.doctor;

import javax.persistence.*;

@Entity(name="Doctor")
@Table(name="doctor", uniqueConstraints = {
                             @UniqueConstraint(name="doctor_email_unique"
                                          , columnNames="email"),
                             @UniqueConstraint(name="doctor_phoneNumber_unique",
                                        columnNames="phone_number")}
                              )

public class Doctor {
    @Column(
            name="first_name",
            nullable=false,
            columnDefinition = "TEXT"

    )
    String firstName;
    @Column(
            name="last_name",
            nullable=false,
            columnDefinition = "TEXT"

    )
    String lastName;
    @Column(
            name="email",
            nullable=false,
            columnDefinition = "TEXT"
    )
    String email;
    @Column(
            name="phone_number",
            nullable=false,
            columnDefinition = "TEXT"

    )
    String phoneNumber;
    @Column(name="id")
    @Id
    //@SequenceGenerator(name="doctor_sequence",
                       //sequenceName = "doctor_sequence",
                       //allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long Id;

    @OneToOne(mappedBy="doctor", cascade=CascadeType.ALL)
    private Address address;


    public Doctor(String firstName,
                  String lastName,
                  String email,
                  String phoneNumber,
                  Long Id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Id = Id;

    }

    public Doctor() {

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
    public Long getId(){
        return Id;
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
    public void setId(Long Id){
        this.Id = Id;
    }

    public Address getAddress(){
        return address;
    }


}
