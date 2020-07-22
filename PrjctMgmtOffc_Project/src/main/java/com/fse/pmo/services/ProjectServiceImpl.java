package com.fse.pmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fse.pmo.dao.ProjectDaoImpl;
import com.fse.pmo.model.PmoProject;
import com.fse.pmo.model.UpdateRequest;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDaoImpl projectDao;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment environment;
	
	@Override
	public Integer saveUpadteProject(PmoProject project) {
		Integer result = projectDao.saveUpadteProject(project);
		if( result > 0 && project.getUserId() != null) {
			UpdateRequest updateRequest = new UpdateRequest();
			updateRequest.setProjectID(project.getProject_id());
			updateRequest.setManager_check(1);
			updateRequest.setUserID(project.getUserId());
			String apiURL = environment.getProperty("user.url");
			updateRequest.setIsDelete(false);
			ResponseEntity<String> response = restTemplate.postForEntity(apiURL, updateRequest, String.class);
			
		}
		
		return result;
	}

	@Override
	public List<PmoProject> getAllProjects() {
		return projectDao.getAllProjects() ;
	}

	@Override
	public PmoProject getProjectById(Integer projectId) {
		return projectDao.getProjectById(projectId) ;
	}

	@Override
	public Integer deleteProjectById(Integer projectId) {
		return projectDao.deleteProjectById(projectId) ;
	}
}
