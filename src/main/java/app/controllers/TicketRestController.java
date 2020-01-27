package app.controllers;


import app.models.Ticket;
import app.models.errors.NoRecordFoundExeption;
import app.services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
public class TicketRestController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/download/{id}", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> downloadTicket(@PathVariable("id") Long id) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            Optional<Ticket> ticket = ticketService.getTicketById(id);
            if (ticket.isPresent()) {
                //TODO generate pdf
                return new ResponseEntity<InputStreamResource>(new InputStreamResource(new ByteArrayInputStream(objectMapper.writeValueAsBytes(ticket.get()))), headers, HttpStatus.OK);
            } else {
                throw new NoRecordFoundExeption("not found ticket with id " + id);
            }

        } catch (JsonProcessingException e) {
            //TODO login
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private PDDocument createPdf(Ticket ticket) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText(objectMapper.writeValueAsString(ticket));
            contentStream.endText();
            contentStream.close();
            return document;
            //document.save("ticket.pdf");
            //document.close();
        } catch (Exception e) {
            throw new RuntimeException("cannot create pdf document");
        }
    }
}
