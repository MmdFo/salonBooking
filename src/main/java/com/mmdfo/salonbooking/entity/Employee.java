package com.mmdfo.salonbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {

    private String employeeCode;

    private Integer workExperience;

    private Double rating;

    @Column(length = 1000)
    private String bio;

}