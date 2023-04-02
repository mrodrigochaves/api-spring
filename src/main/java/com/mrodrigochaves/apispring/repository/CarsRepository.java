package com.mrodrigochaves.apispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrodrigochaves.apispring.model.Car;

@Repository
public interface CarsRepository extends JpaRepository< Car, Long>{
    
    

}
