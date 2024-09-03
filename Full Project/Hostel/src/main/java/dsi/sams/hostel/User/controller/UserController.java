package dsi.sams.hostel.User.controller;

import dsi.sams.hostel.Auth.request.LoginRequest;
import dsi.sams.hostel.Auth.service.RegistrationService;
import dsi.sams.hostel.User.dto.AppUser;
import dsi.sams.hostel.User.service.AppUserService;
import dsi.sams.hostel.User.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class UserController {
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


    @GetMapping(path="/profile")
    public String viewProfile(Model model)
    {
        log.info("Profile page called");

        return "profile";
    }

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
