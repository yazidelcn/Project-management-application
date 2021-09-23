package com.elcnyazid.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elcnyazid.pma.entities.Employee;
import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.repositories.IEmployeeRepository;
import com.elcnyazid.pma.repositories.IProjectRepository;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {

	@Autowired
	IProjectRepository projectRepo;
	@Autowired
	IEmployeeRepository employeeRepo;

	@GetMapping
	public String getHome(Model model) {
		List<Project> projects = projectRepo.findAll();
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);
		model.addAttribute("projects", projects);
		return "main/home";
	}

}
