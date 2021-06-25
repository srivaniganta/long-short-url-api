package com.example.urlshortener.exception;

import com.example.urlshortener.controller.ShortLongUrlController;
import com.example.urlshortener.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class URLGlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ShortLongUrlController.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> constraintViolationException(ConstraintViolationException constraintViolationException){
        ErrorDTO errorDTO = new ErrorDTO();
        constraintViolationException.getConstraintViolations().stream()
                .forEach(constraintViolation -> {
                    errorDTO.setErrorMessage(constraintViolation.getMessage());
                });
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
