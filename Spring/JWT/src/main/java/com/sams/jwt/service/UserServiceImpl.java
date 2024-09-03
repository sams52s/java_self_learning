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
    public void deleteUserById(long id) {
        try{
            appUserRepository.deleteById(id);
        }catch (Exception error){
//            System.out.println(error);
            error.printStackTrace();
        }
        System.out.println(id);
    }

    @Override
    public List<AppUser> getAllUsers(){return appUserRepository.findAll();}

    @Override
    public AppUser getUserById(long id) {
        Optional<AppUser> optional= appUserRepository.findById(id);
        AppUser user=null;
        if(optional.isPresent()){
            user = optional.get();
        }
        else {
            throw new RuntimeException("User ID Not found");
        }
        return user;
    }


}
