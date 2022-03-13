package com.sams.jwt.service;

import com.sams.jwt.model.dto.AppUser;

import java.util.List;


public interface UserService {
    List<AppUser> getAllUsers();
}
