package br.com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.po.Employee;
import br.com.rest.services.interfaces.EmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		LOGGER.debug("Adicionado: {}", employee);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteEmployee(@PathVariable("id") Long id) {
		Employee e = getEmployee(id);
		employeeService.deleteEmployee(id);
		LOGGER.debug("Excluído: {}", e);
	}
}
