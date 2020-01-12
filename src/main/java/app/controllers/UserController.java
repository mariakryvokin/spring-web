package app.controllers;

import app.models.Event;
import app.models.Role;
import app.models.User;
import app.models.enums.RoleEnum;
import app.services.TicketService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

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

    @PostMapping(value = "/cart", headers = "accept=application/pdf")
    public ModelAndView doCart(@ModelAttribute User user, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("cart");
        if(user!=null && user.getEmail() != null){
            User registeredUser = userService.getUserByEmail(user.getEmail());
            if(registeredUser != null){
                modelAndView.getModel().put("ticketsToBeBought",ticketService.getCartTicketsByUserIdAndOrderId(registeredUser.getId(), null));
            }
        }else{
            //TODO get all tickets by generated user id (unregistered user)
        }
        return modelAndView;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("event", new Event());
        return "cartForm";
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
