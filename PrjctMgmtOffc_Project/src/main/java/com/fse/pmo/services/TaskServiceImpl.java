package com.fse.pmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fse.pmo.dao.TaskDaoImpl;
import com.fse.pmo.model.PmoTask;
import com.fse.pmo.model.UpdateRequest;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDaoImpl taskDaoImpl;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Integer saveUpadteTask(PmoTask task) {
		Integer result = taskDaoImpl.saveUpadteTask(task);
		if( result > 0 && task.getUserId() != null) {
			UpdateRequest pr = new UpdateRequest();
			pr.setProjectID(task.getProject().getProject_id());
			pr.setTaskID(task.getId());
			pr.setIsDelete(false);
			pr.setUserID(task.getUserId());
			String apiURL = environment.getProperty("user.url");
			restTemplate.postForEntity(apiURL, pr, String.class);
			result = 1;
			}
			return result;
	}

	@Override
	public List<PmoTask> getAllTasks() {
		return taskDaoImpl.getAllTasks();
	}

	@Override
	public PmoTask getTaskById(Integer taskId) {
		return taskDaoImpl.getTaskById(taskId);
	}

	@Override
	public Integer deleteTaskById(Integer taskId) {
		return taskDaoImpl.deleteTaskById(taskId);
	}

}
