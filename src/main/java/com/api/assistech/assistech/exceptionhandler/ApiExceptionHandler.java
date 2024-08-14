package com.api.assistech.assistech.exceptionhandler;

import com.api.assistech.assistech.exception.ExceptionService;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("Um ou mais campos inválidos");
        problemDetail.setType(URI.create("https://assistech.com/erros/campos-invalidos"));

        var fields = ex.getBindingResult().getAllErrors()
                        .stream()
                                .collect(Collectors.toMap(objectError -> ((FieldError) objectError).getField(),
                                                objectError -> objectError.getDefaultMessage()));
//
//        ex.getBindingResult().getAllErrors()
//                .stream()
//                .forEach(objectError ->
//                        System.out.println(((FieldError) objectError).getField() + " - " + objectError.getDefaultMessage()));


        problemDetail.setProperty("campos" , fields);

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }

    @ExceptionHandler(ExceptionService.class)
    public ProblemDetail capturar(ExceptionService e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(e.getMessage());
        problemDetail.setType(URI.create("https://assistech.com/erros/regras-de-negocio"));

        return problemDetail;
    }


}
