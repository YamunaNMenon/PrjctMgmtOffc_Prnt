package com.fse.pmo.services;

import java.util.List;

import com.fse.pmo.model.PmoProject;

public interface ProjectService {

	public Integer saveUpadteProject(PmoProject project);
	public List<PmoProject> getAllProjects();
	public PmoProject getProjectById(Integer projectId);
	public Integer deleteProjectById(Integer projectId);

}
