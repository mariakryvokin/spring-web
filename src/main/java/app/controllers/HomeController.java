package app.controllers;

import app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }


}
