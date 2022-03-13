package com.sams.jwt.service;

import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

}
