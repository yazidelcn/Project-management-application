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
import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.services.EmployeeService;
import com.elcnyazid.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects =projectService.getAll();
		model.addAttribute("projects", projects);
		return "project/projectDisplay";
	}
	
	@GetMapping("/new")
	public String projectForm(@ModelAttribute("project") Project project, Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("empList", employees);
		return "project/projectForm";
	}
	
	@PostMapping("/saveProject")
	public String processForm(@ModelAttribute("project") Project project) {
		projectService.save(project);
		return "redirect:/projects/";
	}

}
