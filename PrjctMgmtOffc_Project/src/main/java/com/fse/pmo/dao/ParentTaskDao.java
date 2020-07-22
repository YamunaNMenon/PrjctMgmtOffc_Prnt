package com.fse.pmo.dao;

import java.util.List;

import com.fse.pmo.model.PmoParentTask;

public interface ParentTaskDao {

	public Integer saveUpadteParentTask(PmoParentTask parentTask);
	public List<PmoParentTask> getAllParentTasks();
	public PmoParentTask getParentTaskById(Integer parentTaskId);
	public Integer deleteParentTaskById(Integer parentTaskId);
}
