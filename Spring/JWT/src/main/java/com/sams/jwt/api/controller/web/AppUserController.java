package com.sams.jwt.api.controller.web;

import com.sams.jwt.api.controller.LoginRequest;
import com.sams.jwt.api.controller.RegistrationRequest;
import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.service.AppUserService;
import com.sams.jwt.service.RegistrationService;
import com.sams.jwt.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Slf4j
@Controller
@AllArgsConstructor
public class AppUserController {

    private final RegistrationService registrationService;

    @Autowired
    private UserService userService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/alluser")
    public String viewHomePage(Model model)
    {
        log.info("All User page called");
        List<AppUser> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "alluser";
    }
   @PostMapping(path="/profile")
    public String login(LoginRequest request)
    {
        log.info("home page called");
        System.out.println(request);
        System.out.println(request.getEmail());
        log.info("Log In");
        appUserService.loadUserByUsername(request.getEmail());
        return registrationService.login(request.getEmail());
    }
    @GetMapping(path="/profile")
    public String viewProfile(Model model)
    {
        log.info("Profile page called");

        return "profile";
    }
    @GetMapping("login")
    public String getLogin() {
        log.info("Login page called");
        return "login";
    }

    @GetMapping("registration")
    public String getRegistration() {
        log.info("Registration page called");
        return "registration";
    }
   @PostMapping(path = "/registration")
    public String register(RegistrationRequest request) {
        log.info("New Registration");
        return registrationService.register(request) ;
    }

    @GetMapping(path = "api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
