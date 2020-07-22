package com.fse.pmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pmo.model.PmoProject;
import com.fse.pmo.services.ProjectServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@PostMapping("/project/saveUpdateProject")
	public Integer createOrUpdate(@RequestBody PmoProject project) {
		return projectService.saveUpadteProject(project);
	}
	
	@GetMapping("/project/getAllProjects")
	public List<PmoProject> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@GetMapping("/project/getProject/{project_id}")
	public PmoProject getProjectById(@PathVariable String project_id) {
		return projectService.getProjectById(Integer.parseInt(project_id));
	}
	
	@DeleteMapping("/project/delete/{project_id}")
	public Integer deleteProject(@PathVariable String project_id) {
		return projectService.deleteProjectById(Integer.parseInt(project_id));
	}

}
