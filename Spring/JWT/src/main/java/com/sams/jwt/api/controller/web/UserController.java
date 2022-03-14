package com.sams.jwt.api.controller.web;
import com.sams.jwt.api.controller.LoginRequest;
import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.service.AppUserService;
import com.sams.jwt.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping(path = "/showFormForUpdate/{email}")
    public String showFormForUpdate(@PathVariable (value = "email") String email, Model model){
        UserDetails Users = appUserService.loadUserByUsername(email);
        model.addAttribute("Users", Users);
        return "/userUpdate";
    }
    @GetMapping(path = "/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id){
        this.userService.deleteUserById(id);
        return "redirect:/alluser";
    }
    @PostMapping(path = "/userUpdate")
    public String userUpdate(LoginRequest request,Model model){
       // appUserService.loadUserByUsername(request.getEmail());
/*        UserDetails Users = appUserService.loadUserByUsername(request.getEmail());
        model.addAttribute("Users", Users);*/
        return "/userUpdate";
    }


}
