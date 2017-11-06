package br.com.rest.services.interfaces;

import java.util.List;

import br.com.rest.po.Employee;

public interface EmployeeService {

	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee employee);
	
	void deleteEmployee(Long id);
}
