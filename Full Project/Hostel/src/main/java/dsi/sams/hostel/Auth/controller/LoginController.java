package dsi.sams.hostel.Auth.controller;

import dsi.sams.hostel.Auth.request.LoginRequest;
import dsi.sams.hostel.Auth.service.RegistrationService;
import dsi.sams.hostel.User.service.AppUserService;
import dsi.sams.hostel.User.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@AllArgsConstructor
public class LoginController {

    private final RegistrationService registrationService;
    @Autowired
    private UserService userService;
    @Autowired
    private AppUserService appUserService;

    @PostMapping(path="/profile")
    public String login(LoginRequest request, Model model )
    {
        log.info("home page called");
        System.out.println(request);
        System.out.println(request.getEmail());
        log.info("Log In");
        appUserService.loadUserByUsername(request.getEmail());
        UserDetails Users = appUserService.loadUserByUsername(request.getEmail());
        model.addAttribute("Users", Users);
        return registrationService.login(request.getEmail());
    }
    @GetMapping("login")
    public String getLogin(@RequestParam(value="invalid-session",defaultValue="false")boolean invalidSession,
                           final Model model) {
        if(invalidSession){
            model.addAttribute("session", "Session expired, Please re-login");
        }
        log.info("Login page called");
        return "login";
    }
}
