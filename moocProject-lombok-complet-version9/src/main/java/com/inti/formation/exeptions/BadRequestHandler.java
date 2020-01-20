package com.inti.formation.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestHandler extends RuntimeException {
   public BadRequestHandler(String message) {
        super(message);
    }
}
