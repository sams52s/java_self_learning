package dsi.sams.hostel.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    @GetMapping("/Registration")
    public String viewRegistration(){
        log.info("Registration Page Viewed");
        return"/Auth/Registration";
    }
}
