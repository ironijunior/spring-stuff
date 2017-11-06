package br.com.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rest.po.Employee;
import br.com.rest.repository.EmployeeRepository;

@SpringBootApplication
public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.save(new Employee("Gustavo", "Ponce", true));
			employeeRepository.save(new Employee("John", "Smith", true));
			employeeRepository.save(new Employee("Jim ", "Morrison", false));
			employeeRepository.save(new Employee("David", "Gilmour", true));
			LOGGER.info("Dados gerados");
		};
	}
	
}
