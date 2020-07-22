package com.fse.pmo.dao;

import java.util.List;

import com.fse.pmo.model.PmoProject;

public interface ProjectDao {
	
	public Integer saveUpadteProject(PmoProject project);
	public List<PmoProject> getAllProjects();
	public PmoProject getProjectById(Integer projectId);
	public Integer deleteProjectById(Integer projectId);

}
