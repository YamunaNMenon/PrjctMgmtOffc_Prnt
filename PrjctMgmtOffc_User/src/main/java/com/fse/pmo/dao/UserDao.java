package com.fse.pmo.dao;

import java.util.List;

import com.fse.pmo.model.PmoUser;
import com.fse.pmo.model.UpdateRequest;

public interface UserDao {
	
	public Integer saveUpadteUser(PmoUser user);
	public List<PmoUser> getAllUsers();
	public PmoUser getUserById(Integer userId);
	public Integer deleteUserById(Integer userId);
	Integer updateProjectInUser(UpdateRequest updateRequest);

}
