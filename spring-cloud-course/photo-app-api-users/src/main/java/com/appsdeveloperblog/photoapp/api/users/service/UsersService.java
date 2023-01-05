package com.appsdeveloperblog.photoapp.api.users.service;

import com.appsdeveloperblog.photoapp.api.users.shared.UserDTO;

public interface UsersService {
    UserDTO createUser(UserDTO userDetails);
}
