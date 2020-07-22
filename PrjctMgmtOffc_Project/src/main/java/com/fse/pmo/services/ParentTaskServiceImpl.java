package com.fse.pmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.pmo.dao.ParentTaskDaoImpl;
import com.fse.pmo.model.PmoParentTask;

@Service
public class ParentTaskServiceImpl implements ParentTaskService {

	@Autowired
	ParentTaskDaoImpl parentTaskDaoImpl;
	
	@Override
	public Integer saveUpadteParentTask(PmoParentTask parentTask) {
		return parentTaskDaoImpl.saveUpadteParentTask(parentTask);
	}

	@Override
	public List<PmoParentTask> getAllParentTasks() {
		return parentTaskDaoImpl.getAllParentTasks();
	}

	@Override
	public PmoParentTask getParentTaskById(Integer parentTaskId) {
		return parentTaskDaoImpl.getParentTaskById(parentTaskId);
	}

	@Override
	public Integer deleteParentTaskById(Integer parentTaskId) {
		return parentTaskDaoImpl.deleteParentTaskById(parentTaskId);
	}
	
}
