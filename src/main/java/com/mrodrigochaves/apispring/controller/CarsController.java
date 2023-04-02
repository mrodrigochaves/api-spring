package com.mrodrigochaves.apispring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrodrigochaves.apispring.model.Car;
import com.mrodrigochaves.apispring.repository.CarsRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor

public class CarsController {

    
    private CarsRepository carsRepository;



    @GetMapping
    public List<Car> list(){
        return carsRepository.findAll();
    }
    
}
