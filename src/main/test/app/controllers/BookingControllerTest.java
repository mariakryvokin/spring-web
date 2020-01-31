package app.controllers;

import app.models.dto.TicketPdfDto;
import app.services.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/dispatcher-servlet.xml")
class BookingControllerTest {


    @Autowired
    private TicketService ticketService;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void booking() {
        restTemplate.getMessageConverters().add(new TicketPdfAbstractHttpMessageConverter());
        //restTemplate.getMessageConverters().add(new TicketPdfConverter());
        HttpHeaders httpHeaders = restTemplate.headForHeaders("http://localhost:8080/app/download/1");
        Assertions.assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_PDF));
        Assertions.assertNotNull(restTemplate.getForObject("http://localhost:8080/app/download/{id}", TicketPdfDto.class, 1));
    }

}