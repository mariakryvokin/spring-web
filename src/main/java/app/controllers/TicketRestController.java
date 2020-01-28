package app.controllers;


import app.models.Ticket;
import app.models.dto.TicketDto;
import app.models.errors.NoRecordFoundExeption;
import app.services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class TicketRestController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/download/{id}", produces = "application/pdf")
    public byte[] downloadTicket(@PathVariable("id") Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            Optional<Ticket> ticket = ticketService.getTicketById(id);
            if (ticket.isPresent()) {
                TicketDto ticketDto = new TicketDto(ticket.get().getId(),ticket.get().getSeat(), ticket.get().getTimestamp(),
                        ticket.get().getEventHasAuditorium().getEvent().getName(), ticket.get().getEventHasAuditorium().getAirDate(),ticket.get().getEventHasAuditorium().getAuditorium().getName());

                InputStream inputStream = createPdf(ticketDto);
                return new byte[inputStream.available()];
                //return new ResponseEntity<InputStreamResource>(new InputStreamResource(new ByteArrayInputStream(objectMapper.writeValueAsBytes(ticket.get()))), headers, HttpStatus.OK);
            } else {
                throw new NoRecordFoundExeption("not found ticket with id " + id);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //TODO
        return null;
    }

    private InputStream createPdf(TicketDto ticket) throws IOException, DocumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        PdfPTable table = new PdfPTable(6);
        table.addCell("Ticket id");
        table.addCell("Purchase time");
        table.addCell("Event name");
        table.addCell("Air date");
        table.addCell("Auditorium name");
        table.addCell("Seat");
        table.addCell(String.valueOf(ticket.getId()));
        table.addCell(ticket.getPurchaseTimestamp().toString());
        table.addCell(ticket.getEventName());
        table.addCell(ticket.getAirDate().toString());
        table.addCell(ticket.getAuditoriumName());
        table.addCell(String.valueOf(ticket.getSeat()));
        document.add(table);
        document.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
