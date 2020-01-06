package app.controllers;

import app.models.Auditorium;
import app.models.EventHasAuditorium;
import app.models.Ticket;
import app.models.User;
import app.services.AuditoriumService;
import app.services.EventHasAuditoriumService;
import app.services.TicketService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Controller
public class BookingController {
    @Autowired
    private EventHasAuditoriumService eventHasAuditoriumService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private UserService userService;
    private long id = 0;

    @GetMapping("/booking")
    public String bookTicket(Model model) {
        Map<EventHasAuditorium, List<Long>> freeSeats = new HashMap<>();
        List<Ticket> tickets = ticketService.getAll();
        Map<EventHasAuditorium, List<Long>> occupiedSeats = tickets.stream().collect(Collectors.groupingBy(Ticket::getEventHasAuditorium, Collectors.mapping(Ticket::getSeat, Collectors.toList())));

        List<EventHasAuditorium> eventHasAuditoriums = eventHasAuditoriumService.getAll();
        List<Auditorium> auditoriums = auditoriumService.getAll();

        Map<Auditorium, List<Long>> allSeatsInAuditorium = auditoriums.stream().collect(Collectors.toMap(Function.identity(), a -> LongStream.rangeClosed(1, a.getAmountOfSeats())
                .boxed().collect(Collectors.toList())));

        eventHasAuditoriums.stream().distinct().forEach(e -> {
            List<Long> seats = allSeatsInAuditorium.get(e.getAuditorium());
            if (seats != null) {
                if (occupiedSeats.get(e) != null) {
                    seats.removeAll(occupiedSeats.get(e));
                }
                freeSeats.put(e, seats);
            }
        });
        model.addAttribute("freeSeatsEntrySet", freeSeats.entrySet());
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("user", new User());
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
        ticketService.save(ticket);
        return "index";
    }

}
