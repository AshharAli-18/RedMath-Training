package com.training.Lecture3.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {   //Here first argument is the type of enity that spring manages and second is the datatype of primary key for the primary key for that entity
}
