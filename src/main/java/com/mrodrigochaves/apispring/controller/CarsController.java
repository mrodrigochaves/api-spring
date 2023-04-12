package com.mrodrigochaves.apispring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrodrigochaves.apispring.model.Car;
import com.mrodrigochaves.apispring.repository.CarsRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor

public class CarsController {

    
    private CarsRepository carsRepository;


    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public @ResponseBody List<Car> list(){
        return carsRepository.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED )
    public Car create(@RequestBody Car car ) {
        return carsRepository.save(car);
              
    }
    
}
