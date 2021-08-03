package ua.goit.prodApp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.prodApp.service.UserService;


@Controller
@RequestMapping("/")
@Slf4j
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping()
    public String doGet() {
        log.info("doGet .");
        return "index";
    }

    @PostMapping
    public String doPost() {
        log.info("doPost .");
        return "index";
    }

    @GetMapping("login")
    public String login(Model model, String error, String logout) {
        log.info("doPost .");
        if (error != null) {
            log.error("login . Username or password is invalid");
            model.addAttribute("error", "Your username or password is invalid");
        }
        if (logout != null) {
            log.info("login . Log out happened");
            model.addAttribute("message", "You have been logged out");
        }
        return "login";
    }
}
