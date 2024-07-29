package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (userService.tekseriu(username, password)) {
            model.addAttribute("username", username);
            return "profile";
        }
        model.addAttribute("error", "Kateee BRAT");
        return "login";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam String username,
                          Model model) {
        User user = userService.getUser(username).orElse(null);
        if (user != null) {
            model.addAttribute("username", user.getUsername());
        } else {
            return "login";
        }
        return "profile";
    }
}
