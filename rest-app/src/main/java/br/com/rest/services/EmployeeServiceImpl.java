package br.com.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.po.Employee;
import br.com.rest.repository.EmployeeRepository;
import br.com.rest.services.interfaces.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.delete(id);
	}
	
}
