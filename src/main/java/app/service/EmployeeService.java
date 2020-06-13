package app.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.EmployeeRequest;
import app.dto.EmployeeUpdateRequest;
import app.entity.Employee;
import app.repository.EmployeeRepository;

@Service
@Transactional(rollbackOn = Exception.class)
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
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);	
	}
	
	public void create(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		
		employee.setLastName(employeeRequest.getLastName());
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setKanaLastName(employeeRequest.getKanaLastName());
		employee.setKanaFirstName(employeeRequest.getKanaFirstName());
		employee.setAge(employeeRequest.getAge());
		employee.setPhone(employeeRequest.getPhone());
		employee.setEmail(employeeRequest.getEmail());
		employee.setCreateDate(new Date());
		employee.setUpdateDate(new Date());
		employeeRepository.save(employee);
	}
	
	public List<Employee> searchByEmployeeLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}
}
