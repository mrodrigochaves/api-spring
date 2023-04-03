package com.mrodrigochaves.apispring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Car {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column( length = 200, nullable = false)
    private String name;

    @Column( length = 20, nullable = false)
    private String category;

    @Column( length = 20, nullable = false)
    private String color;

    private double kmOut;

    private double kmIn;


}
