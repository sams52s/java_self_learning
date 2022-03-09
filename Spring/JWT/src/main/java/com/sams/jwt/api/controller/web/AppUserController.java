package com.sams.jwt.api.controller.web;

import com.sams.jwt.api.controller.RegistrationRequest;
import com.sams.jwt.model.dto.AppUser;
import com.sams.jwt.service.RegistrationService;
import com.sams.jwt.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final RegistrationService registrationService;

    @Autowired
    private UserService userService;

    @GetMapping("home")
    public String viewHomePage(Model model)
    {
        List<AppUser> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "home";
    }
    @GetMapping("login")
    public String getLogin() {
        return "login";
    }
    @GetMapping("registration")
    public String getRegistration() {
        return "registration";
    }
   @PostMapping(path = "registration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
