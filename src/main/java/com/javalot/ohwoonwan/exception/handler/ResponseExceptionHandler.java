package com.javalot.ohwoonwan.exception.handler;

import com.javalot.ohwoonwan.exception.BadRequestException;
import com.javalot.ohwoonwan.model.BaseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author hazel
 */

@ControllerAdvice
@RequiredArgsConstructor
@RestController
@Slf4j

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceAccessor messageSourceAccessor;

    /*@Controller, @RestController가 적용된 Bean내에서 BadRequest가 발생하면 에러를 잡아 처리.*/
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handle(Exception exception){

        String defaultErCode = "ER-9999";
        BaseModel baseModel = new BaseModel();
        String erCode;
        if (exception.getMessage().length() <= 0) {
            erCode = defaultErCode;
        } else {
            erCode = exception.getMessage();
        }

        try {
            baseModel.setCode(erCode);
            baseModel.setMessage(messageSourceAccessor.getMessage(erCode));
        } catch (Exception e) {
            baseModel.setCode(defaultErCode);
            baseModel.setCode(messageSourceAccessor.getMessage(defaultErCode));
        }

        baseModel.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(baseModel);
    }


}
