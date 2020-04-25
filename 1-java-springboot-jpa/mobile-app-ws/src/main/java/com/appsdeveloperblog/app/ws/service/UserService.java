package com.appsdeveloperblog.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloperblog.app.ws.shared.dto.UserDTO;

public interface UserService extends UserDetailsService{
	
	UserDTO createUser(UserDTO user);

}
