package br.com.mv.controller;

import br.com.mv.dto.errors.ErrorMessageDTO;

import br.com.mv.exceptions.BadRequestException;
import br.com.mv.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsController {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessageDTO> badRequestError (BadRequestException ex) {
        ErrorMessageDTO badRequest = new ErrorMessageDTO(HttpStatus.BAD_REQUEST.value(), ex.getErro(), ex.getDescricao());
        return new ResponseEntity<ErrorMessageDTO>(badRequest, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> notFoundError (NotFoundException ex) {
        ErrorMessageDTO badRequest = new ErrorMessageDTO(HttpStatus.NOT_FOUND.value(), ex.getErro(), ex.getDescricao());
        return new ResponseEntity<ErrorMessageDTO>(badRequest, HttpStatus.NOT_FOUND);
    }
}
