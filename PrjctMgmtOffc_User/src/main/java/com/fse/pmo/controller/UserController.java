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

import com.fse.pmo.model.PmoUser;
import com.fse.pmo.model.UpdateRequest;
import com.fse.pmo.services.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/user/saveUpdateUser")
	public Integer createOrUpdate(@RequestBody PmoUser user) {
		return userService.saveUpadteUser(user);
	}
	
	@GetMapping("/user/getAllUsers")
	public List<PmoUser> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/getUser/{id}")
	public PmoUser getUserById(@PathVariable String userId) {
		return userService.getUserById(Integer.parseInt(userId));
	}
	
	@DeleteMapping("/user/delete/{id}")
	public Integer deleteUser(@PathVariable String id) {
		return userService.deleteUserById(Integer.parseInt(id));
	}
	
	@PostMapping("/user/updateProjectInUser")
	public Integer updateProjectInUser(@RequestBody UpdateRequest updateRequest) {
		return userService.updateProjectInUser(updateRequest);
		
	}

}
