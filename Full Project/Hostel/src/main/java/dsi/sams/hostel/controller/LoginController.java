package dsi.sams.hostel.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Path;

@Slf4j
@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    @GetMapping("/Login")
    public String viewLogin(){
        log.info("Login Page Viewed");
        return"/Auth/Login";
    }
}
