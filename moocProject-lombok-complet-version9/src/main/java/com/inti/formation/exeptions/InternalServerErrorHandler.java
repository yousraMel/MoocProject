package com.inti.formation.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorHandler extends RuntimeException {
    public InternalServerErrorHandler(String message) {
        super(message);
    }
}

