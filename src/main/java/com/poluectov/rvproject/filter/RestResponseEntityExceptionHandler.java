package com.poluectov.rvproject.filter;

import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.repository.exception.ValidationError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "IllegalArgumentException";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /*@Nullable
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                headers, status, request);
    }*/

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        log.debug(
                "Constraint violation exception encountered: {}",
                ex.getConstraintViolations(),
                ex
        );

        List<ValidationError> errors = buildValidationErrors(
                ex.getConstraintViolations()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
    }

    /**
     * Build list of ValidationError from set of ConstraintViolation
     *
     * @param violations Set<ConstraintViolation<?>> - Set
     * of parameterized ConstraintViolations
     * @return List<ValidationError> - list of validation errors
     */
    private List<ValidationError> buildValidationErrors(
            Set<ConstraintViolation<?>> violations) {
        return violations.
                stream().
                map(violation ->
                        ValidationError.builder()
                                .field(
                                        StreamSupport.stream(
                                                        violation.getPropertyPath().spliterator(), false)
                                                .reduce((first, second) -> second)
                                                .orElse(null)
                                                .toString()
                                )
                                .error(violation.getMessage())
                                .build())
                        .collect(toList());
    }
}
