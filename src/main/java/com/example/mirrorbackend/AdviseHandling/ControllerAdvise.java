package com.example.mirrorbackend.AdviseHandling;

import com.example.mirrorbackend.API.API;
import com.example.mirrorbackend.Exception.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<API> apiException(ApiException apiException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(apiException.getMessage(),400));
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<API> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error.getMessage(),400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("Server Error !",500));
    }
}
