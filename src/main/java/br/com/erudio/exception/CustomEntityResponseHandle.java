package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
     public final ResponseEntity<ExceptionResponse> handleAllException(Exception x, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), x.getMessage(), x.getLocalizedMessage());
         return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
     }

    @ExceptionHandler(UnsupportedMathOperation.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception x, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), x.getMessage(), x.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResouceNotFundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFundRequestException(Exception x, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), x.getMessage(), x.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
