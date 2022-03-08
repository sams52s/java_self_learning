package com.sams.jwt.api.controller.web;

import com.sams.jwt.api.controller.RegistrationRequest;
import com.sams.jwt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping(path="index")
    public String getIndex(){
        return "index";
    }
    @GetMapping("api/index")
    public String getLogin() {
        return "login";
    }
    @GetMapping("api/registration")
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
