package dsi.sams.logingregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("home")
    public String getCourses() {
        return "home";
    }
}
