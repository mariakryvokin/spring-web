package app.controllers;

import app.models.Role;
import app.models.User;
import app.models.enums.RoleEnum;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private long id =0;

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName(RoleEnum.USER.name());
        roles.add(role);
        user.setRoles(roles);
        userService.save(user);
        return "index";
    }

    @GetMapping("/cart")
    public String cart(@ModelAttribute User user){
        if(user!=null && user.getEmail() != null){
            //TODO get all tickets by user without order id
        }else{
            //TODO get all tickets by generated user id (unregistered user)
        }
        return "cart";
    }

    @GetMapping("/unregistered/id")
    public String showId(Model model){
        model.addAttribute("userId",getId());
        return "showID";
    }

    private long getId() {
        return id - 1;
    }
}
