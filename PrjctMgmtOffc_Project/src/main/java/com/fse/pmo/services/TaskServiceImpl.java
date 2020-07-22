package com.fse.pmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.pmo.dao.TaskDaoImpl;
import com.fse.pmo.model.PmoTask;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDaoImpl taskDaoImpl;
	
	@Override
	public Integer saveUpadteTask(PmoTask task) {
		Integer result = taskDaoImpl.saveUpadteTask(task);
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
