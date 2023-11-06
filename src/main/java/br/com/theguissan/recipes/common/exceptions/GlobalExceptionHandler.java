package br.com.theguissan.recipes.common.exceptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(BussinessException.class)
    ResponseEntity<Object> handleBussinessException(final BussinessException exception) {
        return new ResponseEntity<>(
                this.getErrorsMap(Collections.singletonList(exception.getLocalizedMessage())),
                new HttpHeaders(),
                HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<Object> handleBussinessException(final NotFoundException exception) {
        return new ResponseEntity<>(
                this.getErrorsMap(Collections.singletonList(exception.getLocalizedMessage())),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex,
            final HttpHeaders headers,
            final HttpStatusCode status,
            final WebRequest request) {
        
        final List<String> errors = ex.getBindingResult().getFieldErrors()
                                      .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        
        return new ResponseEntity<>(this.getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    private Map<String, List<String>> getErrorsMap(final List<String> errors) {
        final Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
    
}
