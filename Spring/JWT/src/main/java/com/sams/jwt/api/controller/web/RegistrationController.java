package com.sams.jwt.api.controller.web;

import com.sams.jwt.api.controller.RegistrationRequest;
import com.sams.jwt.service.RegistrationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@Controller
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

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
    @GetMapping("/addNewUser")
    public String addNewUser() {
        log.info("addNewUser page called");
        return "addNewUser";
    }
    @PostMapping(path = "/addNewUser")
    public String addNewUser(RegistrationRequest request) {
        log.info("addNewUser Registration");
        return registrationService.register(request) ;
    }

    @GetMapping(path = "api/v1/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
