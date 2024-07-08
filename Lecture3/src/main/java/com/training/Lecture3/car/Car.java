package com.training.Lecture3.car;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cars")
public class Car {
    @Id  //This annotation is used to specify the primary key
    private long carId;
    private String carName;
    private String carBrand;
    private long carModel;
    private long mileage;
    private String registrationNumber;

}
