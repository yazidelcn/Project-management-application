package com.elcnyazid.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elcnyazid.pma.dto.ChartData;
import com.elcnyazid.pma.dto.EmployeeProject;
import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.repositories.IEmployeeRepository;
import com.elcnyazid.pma.repositories.IProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {
	@Value("${version}")
	private String version;
	
	@Autowired
	private IProjectRepository projectRepo;
	@Autowired
	private IEmployeeRepository employeeRepo;

	@GetMapping
	public String getHome(Model model) throws JsonProcessingException {
		List<Project> projects = projectRepo.findAll();
		List<EmployeeProject> employeesProjects = employeeRepo.employeeProjects();
		List<ChartData> stagesData = projectRepo.chartData();
		ObjectMapper objectMapper = new ObjectMapper();
		//converting stagesData to JSON
		String jsonString = objectMapper.writeValueAsString(stagesData);
		model.addAttribute("employeesProjects", employeesProjects);
		model.addAttribute("projects", projects);
		model.addAttribute("stagesData",jsonString);
		model.addAttribute("version", version);
		return "main/home";
	}

}
