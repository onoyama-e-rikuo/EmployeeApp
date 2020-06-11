package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.entity.Employee;
import app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	String top(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList",employeeList);
		return "top";
	}
	
	@GetMapping("/employee/{id}")
	String searchById(@PathVariable int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employeeDetails",employee);
		return "employee/detail";
	}
	
	
}