package com.appsdeveloperblog.photoapp.api.users.controllers;

import com.appsdeveloperblog.photoapp.api.users.models.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.service.UsersService;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment environment;

    @Autowired
    UsersService usersService;

    @GetMapping("/status/check")
    public String getStatus() {
        return "Users Service Working" + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid  @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = modelMapper.map(userDetails,UserDTO.class);
        usersService.createUser(userDTO);
        return "Create User created";
    }




}
