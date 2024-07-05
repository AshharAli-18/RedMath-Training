package com.training.Lecture3.car;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {  //When the object of car service is created, Car repository object must be provided: dependency injection
        this.carRepository = carRepository;
    }

    public Optional<Car> findById(Long carId) {
        return carRepository.findById(carId);
    }

    public List<Car> findAll(Integer page, Integer size) {
        if (page < 0) {
            page = 0;
        }
        if (size > 1000) {
            size = 1000;
        }
        return carRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
