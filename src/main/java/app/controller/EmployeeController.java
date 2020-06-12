package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import app.dto.EmployeeUpdateRequest;
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
		return "details";
	}
	
    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        	Employee employee = employeeService.findById(id);
        	EmployeeUpdateRequest employeeUpdateRequest = new EmployeeUpdateRequest();
        	employeeUpdateRequest.setLastName(employee.getLastName());
        	employeeUpdateRequest.setFirstName(employee.getFirstName());
        	employeeUpdateRequest.setKanaLastName(employee.getKanaLastName());
        	employeeUpdateRequest.setKanaFirstName(employee.getKanaFirstName());
        	employeeUpdateRequest.setAge(employee.getAge());
        	employeeUpdateRequest.setPhone(employee.getPhone());
        	employeeUpdateRequest.setEmail(employee.getEmail());
        	model.addAttribute("employeeUpdateRequest", employeeUpdateRequest);
        	return"edit";
    }

	@PostMapping("/employee/update")
	String update(@Validated @ModelAttribute EmployeeUpdateRequest employeeUpdateRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			
			model.addAttribute("validationError", errorList);
			return "edit";
		}
		
		employeeService.update(employeeUpdateRequest);
		return String.format("redirect:/employee/%d", employeeUpdateRequest.getId());
	}
}