package dsi.sams.hostel.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class AppController {
    /**
     * Global page no validation all user can access.
     * @return It will return the index page.
     */
    @Autowired
    @GetMapping("/")
    public String Index()
    {
        log.info("Index Called");
        return "Index";
    }
}
