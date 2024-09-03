package dsi.sams.hostel.User.service;

import dsi.sams.hostel.User.dto.AppUser;


import java.util.List;


public interface UserService {
    List<AppUser> getAllUsers();
    AppUser getUserById(long id);
    void deleteUserById(long id);

}