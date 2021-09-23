package com.elcnyazid.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elcnyazid.pma.entities.Employee;
import com.elcnyazid.pma.repositories.IEmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);
		return "employee/employeeDisplay";
	}
	
	
	@GetMapping("/new")
	public String employeeForm(@ModelAttribute("emp") Employee employee) {
		return "employee/employeeForm";
	}
	
	@PostMapping("/saveEmployee")
	public String processForm(@ModelAttribute("emp") Employee employee) {
		employeeRepo.save(employee);
		return"redirect:/employees/";
	}

}
