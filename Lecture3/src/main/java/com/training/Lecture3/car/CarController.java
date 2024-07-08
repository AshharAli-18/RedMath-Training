package com.training.Lecture3.car;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }



    @PreAuthorize("hasAnyAuthority('editor')")
    @GetMapping("/api/v1/cars/{carId}")
    public ResponseEntity<Car> get(@PathVariable("carId") Long carId) {  //Pathvariable is a way to capture "carId" part of the URl and use it in the code later on
        Optional<Car> car = carService.findById(carId);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car.get());
    }

    @GetMapping("/api/v1/cars")
    public ResponseEntity<List<Car>> get(@RequestParam(name = "page", defaultValue = "0") Integer page,         //Here requestparam means that these variables are expected in the url request. Page refers to the page number and size refers to the number
                                          @RequestParam(name = "page", defaultValue = "1000") Integer size) {   // of records paer page,If these are not provided, default values are 0 for the page number and 1000 for the number of records
        return ResponseEntity.ok(carService.findAll(page, size));
    }

    @PostMapping("/api/v1/cars")
    public ResponseEntity<Car> create(@RequestBody Car cars) {
        cars = carService.create(cars);
        return ResponseEntity.created(URI.create("/api/v1/cars/" + cars.getCarId())).body(cars);
    }


}
