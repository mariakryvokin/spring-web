package app.controllers;

import app.models.Ticket;
import app.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BookingControllerTest {

    
    @Autowired
    private TicketService ticketService;

    @Test
    public void booking(){
        List<Ticket> unpaidTickets = ticketService.getUnpaidTickets();
    }

}