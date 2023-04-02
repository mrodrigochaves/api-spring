package com.mrodrigochaves.apispring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mrodrigochaves.apispring.model.Car;
import com.mrodrigochaves.apispring.repository.CarsRepository;

@SpringBootApplication
public class ApiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase( CarsRepository carsRepository){
		return args -> {
			carsRepository.deleteAll();

			Car c = new Car();
			c.setName("Fox 1.6");
			c.setCategory("Volkswagen");
			c.setColor("Vermelho");
			c.setKmIn(82120);
			c.setKmOut(85142);

			carsRepository.save(c);
		};
	}

}
