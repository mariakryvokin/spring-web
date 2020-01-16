package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
/*
    @PostMapping("/login")
    public String doLogin(){
        return "login";
    }*/
}
