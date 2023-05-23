package com.mrodrigochaves.apispring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * Endpoint para obter todos os carros.
     *
     * @return Lista de carros
     */
    @GetMapping
    public @ResponseBody List<Car> listar() {
        return carsRepository.findAll();
    }

    /**
     * Endpoint para obter um carro específico pelo seu ID.
     *
     * @param id O ID do carro a ser obtido
     * @return ResponseEntity contendo o carro, se encontrado, ou status de não encontrado caso contrário
     */
    @GetMapping("/{id}")
    public ResponseEntity<Car> encontrarPorId(@PathVariable Long id) {
        return carsRepository.findById(id)
                .map(registro -> ResponseEntity.ok().body(registro))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para criar um novo carro.
     *
     * @param car O objeto carro a ser criado
     * @return O objeto carro criado
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car criar(@RequestBody Car car) {
        return carsRepository.save(car);
    }

}
