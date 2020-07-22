package com.fse.pmo.model;

public class UpdateRequest {
	Integer projectID;
	
	Integer taskID;
	
	private Integer manager_check;
	
	Integer userID;
	
	boolean isDelete;

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getTaskID() {
		return taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getManager_check() {
		return manager_check;
	}

	public void setManager_check(Integer manager_check) {
		this.manager_check = manager_check;
	}
}
