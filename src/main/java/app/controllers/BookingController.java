package app.controllers;

import app.models.Auditorium;
import app.models.EventHasAuditorium;
import app.models.Ticket;
import app.models.User;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Controller
public class BookingController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/booking")
    public String bookTicket(Model model) {
        model.addAttribute("freeSeatsEntrySet", bookingService.getFreeSeats().entrySet());
        model.addAttribute("ticket", new Ticket());
        return "bookingTicket";
    }

    @PostMapping("/booking")
    public String doBookTicket(@ModelAttribute Ticket ticket) {
        if (ticket.getUser() != null && ticket.getUser().getEmail() != null) {
            User user = userService.getUserByEmail(ticket.getUser().getEmail());
            ticket.setUser(user);
        } else if (ticket.getUser() != null && ticket.getUser().getId() != null) {
            ticket.setUser(userService.getById(ticket.getUser().getId()));
        }
        ticket.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        ticketService.save(ticket);
        return "main";
    }


}
