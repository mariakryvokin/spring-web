package app.controllers;

import app.models.dto.TicketPdfDto;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketPdfAbstractHttpMessageConverter extends AbstractHttpMessageConverter<TicketPdfDto> {
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.getName().equals(TicketPdfDto.class.getName());
    }

    @Override
    protected TicketPdfDto readInternal(Class<? extends TicketPdfDto> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return new TicketPdfDto();
    }

    @Override
    protected void writeInternal(TicketPdfDto ticketPdfDto, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.unmodifiableList(Arrays.asList(MediaType.APPLICATION_PDF));
    }
}
