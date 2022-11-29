package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp ="^([A-Z][a-z]+[ ])*([A-Z][a-z]+)$",message = "{firstName}")
    private String firstName;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp ="^[A-Z][a-z]+$",message = "{lastName}")
    private String lastName;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[0][0-9]{8,9}$",message = "{phoneNumber}")
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(50)")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "{email}")
    private String email;

    @Min(value = 18,message = "{age}")
    @Max(value = 99,message = "{age}")
    private Integer age;

    public Customer() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
