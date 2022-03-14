package com.sams.jwt.service;

import com.sams.jwt.model.dto.AppUser;
import org.springframework.social.connect.Connection;

import java.util.List;


public interface UserService {
    List<AppUser> getAllUsers();
    AppUser getUserById(long id);
    void deleteUserById(long id);

}
