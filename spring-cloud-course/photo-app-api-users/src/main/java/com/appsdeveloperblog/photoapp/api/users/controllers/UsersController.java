package com.appsdeveloperblog.photoapp.api.users.controllers;

import com.appsdeveloperblog.photoapp.api.users.models.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.models.CreateUserResponseModel;
import com.appsdeveloperblog.photoapp.api.users.service.UsersService;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid  @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = modelMapper.map(userDetails,UserDTO.class);
        UserDTO createdUser = usersService.createUser(userDTO);

        CreateUserResponseModel returnValue = modelMapper.map(createdUser,CreateUserResponseModel.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }




}
