package com.sams.jwt.api.controller.web;

import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppUserController {

    @Autowired
    private UserService userService;

    @GetMapping("api/home")
    public String viewHomePage(Model model)
    {
        List<AppUser> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "home";
    }
}
