package com.elcnyazid.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.repositories.IProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private IProjectRepository projectRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		return "project/projectDisplay";
	}
	
	@GetMapping("/new")
	public String projectForm(@ModelAttribute("project") Project project) {
		return "project/projectForm";
	}
	
	@PostMapping("/saveProject")
	public String processForm(@ModelAttribute("project") Project project) {
		projectRepo.save(project);
		return "redirect:/projects/";
	}

}
