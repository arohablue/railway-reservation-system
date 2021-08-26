package com.sunbeam.services;

import com.sunbeam.dto.UserDTO;

public interface AdminService {
    Boolean saveUser(UserDTO user);
    Boolean updateUser(UserDTO user);
    Boolean deleteUser(UserDTO user);
}