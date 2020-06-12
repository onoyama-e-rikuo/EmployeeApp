package app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.EmployeeUpdateRequest;
import app.entity.Employee;
import app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}
	
	public void update(EmployeeUpdateRequest employeeUpdateRequest) {
		Employee employee = findById(employeeUpdateRequest.getId());
		
		employee.setLastName(employeeUpdateRequest.getLastName());
		employee.setFirstName(employeeUpdateRequest.getFirstName());
		employee.setKanaLastName(employeeUpdateRequest.getKanaLastName());
		employee.setKanaFirstName(employeeUpdateRequest.getKanaFirstName());
		employee.setAge(employeeUpdateRequest.getAge());
		employee.setPhone(employeeUpdateRequest.getPhone());
		employee.setEmail(employeeUpdateRequest.getEmail());
		employee.setUpdateDate(new Date());
		employeeRepository.save(employee);
	}
}
