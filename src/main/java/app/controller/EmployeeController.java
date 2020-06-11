package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
