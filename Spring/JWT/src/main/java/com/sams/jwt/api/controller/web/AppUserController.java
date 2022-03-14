package com.sams.jwt.api.controller.web;

import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Slf4j
@Controller
@AllArgsConstructor
public class AppUserController {

    @Autowired
    private UserService userService;
    @GetMapping("/alluser")
    public String viewHomePage(Model model)
    {
        log.info("All User page called");
        List<AppUser> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "alluser";
    }
}
