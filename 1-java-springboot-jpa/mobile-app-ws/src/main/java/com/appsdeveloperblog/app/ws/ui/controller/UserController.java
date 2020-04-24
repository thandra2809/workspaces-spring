package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") /* http://localhost:8080/users */
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "get User was called";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();

		UserDTO userDTO = new UserDTO();

		BeanUtils.copyProperties(userDetails, userDTO);

		UserDTO createdUser = userService.createUser(userDTO);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "update user is called";

	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
