package com.javalot.ohwoonwan.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    // 400 Bad Request
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> BadRequestException(final RuntimeException ex) {
        log.error("error", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
